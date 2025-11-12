package testes;

import static org.junit.Assert.assertEquals;

// Importações do JUnit 4
import org.junit.Before;
import org.junit.Test;

// Importações das classes do projeto
import model.Acesso;
import model.Mensalista;
import model.Proprietario;
import servicos.CalculadoraTarifaService;

/**
 * Testes unitários (JUnit 4) para as regras de negócio de tarifação.
 */
public class CalculadoraTarifaServiceTest {

    private CalculadoraTarifaService service;

    // Constantes de tempo em milissegundos para facilitar os testes
    private static final long HORA_ZERO = 0L;
    private static final long MINUTO = 60 * 1000L;
    private static final long HORA = 60 * MINUTO;

    // Delta (margem de erro) para comparação de doubles, exigido pelo JUnit 4
    private static final double DELTA = 0.001;

    @Before 
    public void setUp() {
        // Instancia o serviço antes de cada teste
        service = new CalculadoraTarifaService();
    }

    // --- Testes de Acesso AVULSO ---

    @Test 
    public void testeAvulso30Minutos() {
        Acesso acesso = new Acesso("AVULSO-01", HORA_ZERO, null); // null = Avulso
        long horaSaida = HORA_ZERO + (30 * MINUTO);
        
        // 2 frações * R$ 2,00 = R$ 4,00
        double valor = service.finalizarAcesso(acesso, horaSaida);
        
        // assertEquals com delta para doubles
        assertEquals(4.00, valor, DELTA); 
        // assertEquals sem delta para longs
        assertEquals(horaSaida, acesso.getDataHoraSaida()); 
    }

    @Test
    public void testeAvulso60Minutos() {
        Acesso acesso = new Acesso("AVULSO-02", HORA_ZERO, null);
        long horaSaida = HORA_ZERO + (60 * MINUTO);
        
        // Total = R$ 7,50
        double valor = service.finalizarAcesso(acesso, horaSaida);
        
        assertEquals(7.50, valor, DELTA);
    }

    @Test
    public void testeAvulso70Minutos() {
        Acesso acesso = new Acesso("AVULSO-03", HORA_ZERO, null);
        long horaSaida = HORA_ZERO + (70 * MINUTO);
        
        // Total = R$ 9,50
        double valor = service.finalizarAcesso(acesso, horaSaida);
        
        assertEquals(9.50, valor, DELTA);
    }

    @Test
    public void testeAvulsoLimiteDiaria() {
        Acesso acesso = new Acesso("AVULSO-04", HORA_ZERO, null);
        long horaSaida = HORA_ZERO + (450 * MINUTO);
        
        // Total = R$ 56,50 (Ainda não é a diária)
        double valor = service.finalizarAcesso(acesso, horaSaida);
        
        assertEquals(56.50, valor, DELTA);
    }

    @Test
    public void testeAvulsoAcimaDaDiaria() {
        Acesso acesso = new Acesso("AVULSO-05", HORA_ZERO, null);
        long horaSaida = HORA_ZERO + (451 * MINUTO);
        
        // Total = R$ 55,00
        double valor = service.finalizarAcesso(acesso, horaSaida);
        
        assertEquals(55.00, valor, DELTA);
    }

    @Test
    public void testeAvulso5Minutos() {
        Acesso acesso = new Acesso("AVULSO-06", HORA_ZERO, null);
        long horaSaida = HORA_ZERO + (5 * MINUTO);
        
        // Total = R$ 2,00
        double valor = service.finalizarAcesso(acesso, horaSaida);
        
        assertEquals(2.00, valor, DELTA);
    }

    @Test
    public void testeAvulsoZeroMinutos() {
        Acesso acesso = new Acesso("AVULSO-07", HORA_ZERO, null);
        long horaSaida = HORA_ZERO;
        
        double valor = service.finalizarAcesso(acesso, horaSaida);
        
        assertEquals(0.00, valor, DELTA);
    }

    // --- Testes de Clientes Cadastrados ---

    @Test
    public void testeProprietarioNaoPaga() {
        Proprietario prop = new Proprietario();
        prop.setNome("Proprietário Teste");
        
        Acesso acesso = new Acesso("PROP-01", HORA_ZERO, prop);
        long horaSaida = HORA_ZERO + (4 * HORA); // 4 horas
        
        double valor = service.finalizarAcesso(acesso, horaSaida);
        
        assertEquals(0.00, valor, DELTA);
    }

    @Test
    public void testeMensalistaAdimplenteNaoPaga() {
        Mensalista mensalista = new Mensalista();
        mensalista.setNome("Mensalista Em Dia");
        
        long horaSaida = HORA_ZERO + (2 * HORA); // Sai às 02:00
        long vencimento = HORA_ZERO + (5 * HORA); // Vence às 05:00 (Depois da saída)
        
        mensalista.setDataVencimento(vencimento);
        
        Acesso acesso = new Acesso("MENSAL-01", HORA_ZERO, mensalista);
        double valor = service.finalizarAcesso(acesso, horaSaida);
        
        assertEquals(0.00, valor, DELTA);
    }

    @Test
    public void testeMensalistaInadimplentePagaComoAvulso() {
        Mensalista mensalista = new Mensalista();
        mensalista.setNome("Mensalista Vencido");
        
        long horaSaida = HORA_ZERO + (60 * MINUTO); // Sai às 01:00 (Ficou 60 min)
        long vencimento = HORA_ZERO - (1 * MINUTO); // Venceu 1 min antes da entrada
        
        mensalista.setDataVencimento(vencimento);
        
        Acesso acesso = new Acesso("MENSAL-02", HORA_ZERO, mensalista);
        
        // Deve cobrar R$ 7,50 (regra de 1 hora avulso)
        double valor = service.finalizarAcesso(acesso, horaSaida);
        
        assertEquals(7.50, valor, DELTA);
    }
}