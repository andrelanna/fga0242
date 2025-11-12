package servicos;

import model.Acesso;
import model.Cliente;
import model.Mensalista;
import model.Proprietario;

/**
 * Classe de serviço responsável por conter as regras de negócio
 * e calcular a tarifa do estacionamento.
 */
public class CalculadoraTarifaService {

    // Constantes das regras de negócio
    private static final double PRECO_FRACAO = 2.00;
    private static final double DESCONTO_POR_BLOCO = 0.50;
    private static final int MINUTOS_POR_FRACAO = 15;
    private static final int FRACOES_POR_BLOCO_DESCONTO = 4;
    private static final int LIMITE_FRACOES_DIARIA = 30;
    private static final double VALOR_DIARIA = 55.00;

    /**
     * Método principal que finaliza um acesso, calcula o valor
     * e atualiza o objeto Acesso.
     * * @param acesso O objeto de acesso a ser finalizado.
     * @param horaSaidaTimestamp O timestamp (epoch millis) da saída.
     * @return O valor final a ser pago.
     */
    public double finalizarAcesso(Acesso acesso, long horaSaidaTimestamp) {
        // 1. Atualiza a hora de saída no objeto
        acesso.setDataHoraSaida(horaSaidaTimestamp);

        Cliente cliente = acesso.getCliente();
        double valorFinal = 0.0;

        // 2. Verifica o tipo de cliente
        if (cliente == null) {
            // É AVULSO
            valorFinal = calcularTarifaAvulsa(acesso);
            
        } else if (cliente instanceof Proprietario) {
            // É PROPRIETÁRIO (vaga privativa)
            valorFinal = 0.0;
            
        } else if (cliente instanceof Mensalista) {
            // É MENSALISTA
            Mensalista mensalista = (Mensalista) cliente;
            
            // Verifica se está adimplente NA HORA DA SAÍDA
            if (mensalista.isAdimplente(horaSaidaTimestamp)) {
                valorFinal = 0.0;
            } else {
                // Mensalista inadimplente paga como AVULSO
                valorFinal = calcularTarifaAvulsa(acesso);
            }
        }

        // 3. Atualiza o valor pago no objeto e retorna
        acesso.setValorPago(valorFinal);
        return valorFinal;
    }

    /**
     * Calcula o valor para um cliente avulso (ou mensalista inadimplente).
     */
    private double calcularTarifaAvulsa(Acesso acesso) {
        
        long diffMillis = acesso.getDataHoraSaida() - acesso.getDataHoraEntrada();

        // Se o tempo for 0 ou negativo, não cobra nada
        if (diffMillis <= 0) {
            return 0.0;
        }

        // 1. Calcular o total de minutos e arredondar para cima
        // (Ex: 5 minutos conta como 1 fração de 15)
        double totalMinutos = (double) diffMillis / 60000.0;
        int totalFracoes = (int) Math.ceil(totalMinutos / MINUTOS_POR_FRACAO);

        // 2. Verificar a regra da Diária (Teto)
        // "Acima de 30 frações" (ou seja, 31 ou mais)
        if (totalFracoes > LIMITE_FRACOES_DIARIA) {
            return VALOR_DIARIA;
        }

        // 3. Calcular o valor bruto
        double valorBruto = totalFracoes * PRECO_FRACAO;

        // 4. Calcular o desconto
        // "a cada 4 frações" (usa divisão inteira)
        int numeroBlocosDesconto = totalFracoes / FRACOES_POR_BLOCO_DESCONTO;
        double valorDesconto = numeroBlocosDesconto * DESCONTO_POR_BLOCO;

        // 5. Retornar valor final
        return valorBruto - valorDesconto;
    }
}