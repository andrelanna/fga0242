package app;

class CalculadoraImpostos {
	
	//Referencia para objeto da classe de origem
	private IRPF origem; 
	
	//um atributo para cada variavel temporaria
	private float base; 
	private float impostoTotal;
	
	//construtor do objeto-metodo
	public CalculadoraImpostos(IRPF origem) {
		this.origem = origem;
	}
	
	float computar() {
		base = origem.calcularBaseIRPF();
		impostoTotal = 0f; 
		
		//Calculo do imposto da 5a faixa
		if (base > origem.PISO_5A_FAIXA) {
			origem.base5aFaixa = calcularBaseFaixa(base, origem.PISO_5A_FAIXA);
			origem.imposto5aFaixa = calcularImpostoPorFaixa(origem.base5aFaixa, origem.ALIQUOTA_5A_FAIXA);
			base = atualizarBase(base, origem.base5aFaixa); 
			impostoTotal = calcularImpostoFaixa(impostoTotal, origem.imposto5aFaixa);
		}
		
		//Calculo do imposto da 4a faixa
		if (base > origem.PISO_4A_FAIXA) {
			origem.base4aFaixa = calcularBaseFaixa(base, origem.PISO_4A_FAIXA);
			origem.imposto4aFaixa = calcularImpostoPorFaixa(origem.base4aFaixa, origem.ALIQUOTA_4A_FAIXA);
			base = atualizarBase(base, origem.base4aFaixa); 
			impostoTotal = calcularImpostoFaixa(impostoTotal, origem.imposto4aFaixa);
		}
		
		//Calculo do imposto da 3a faixa
		if (base > origem.PISO_3A_FAIXA) {
			origem.base3aFaixa = calcularBaseFaixa(base, origem.PISO_3A_FAIXA);
			origem.imposto3aFaixa = calcularImpostoPorFaixa(origem.base3aFaixa, origem.ALIQUOTA_3A_FAIXA);
			base = atualizarBase(base, origem.base3aFaixa); 
			impostoTotal = calcularImpostoFaixa(impostoTotal, origem.imposto3aFaixa);
		}
		
		//Calculo do imposto da 2a faixa
		if (base > origem.PISO_2A_FAIXA) {
			origem.base2aFaixa = calcularBaseFaixa(base, origem.PISO_2A_FAIXA);
			origem.imposto2aFaixa = calcularImpostoPorFaixa(origem.base2aFaixa, origem.ALIQUOTA_2A_FAIXA);
			base = atualizarBase(base, origem.base2aFaixa); 
			impostoTotal = calcularImpostoFaixa(impostoTotal, origem.imposto2aFaixa);
		} 
		
		//Calculo do imposto da 1a faixa
		if (base <= origem.PISO_2A_FAIXA) {
			origem.base1aFaixa = base; 
			origem.imposto1aFaixa = calcularImpostoPorFaixa(origem.base1aFaixa, origem.ALIQUOTA_1A_FAIXA);
			base = atualizarBase(base, origem.base1aFaixa); 
			impostoTotal = calcularImpostoFaixa(impostoTotal, origem.imposto1aFaixa);
		}
		
		return impostoTotal;
	}

	private float calcularImpostoFaixa(float impostoTotal, float impostoFaixa) {
		impostoTotal += impostoFaixa;
		return impostoTotal;
	}

	private float atualizarBase(float base, float baseFaixa) {
		base -= baseFaixa;
		return base;
	}

	private float calcularImpostoPorFaixa(float base, float aliquota) {
		return base * aliquota;
	}

	private float calcularBaseFaixa(float base, float piso_faixa) {
		return base - piso_faixa;
	}
}
