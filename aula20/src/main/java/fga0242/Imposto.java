package main.java.fga0242;

public class Imposto {

	
	
	public float getTotalFaixaBaseDeCalculo(IRPF irpf) {
		return new Faixa1().getOcupacaoFaixa(irpf) + 
				new Faixa2().getOcupacaoFaixa(irpf) + 
				new Faixa3().getOcupacaoFaixa(irpf) + 
				new Faixa4().getOcupacao4aFaixa(irpf) + 
				new Faixa5().getOcupacao5aFaixa(irpf);
	}

	public float getTotalImposto(IRPF irpf) {
		return irpf.getImposto1aFaixa() + 
				irpf.getImposto2aFaixa() + 
				irpf.getImposto3aFaixa() + 
				irpf.getImposto4aFaixa() + 
				irpf.getImposto5aFaixa(); 
	}

	public float getOcupacao1aFaixa(IRPF irpf) {
		return new Faixa1().getOcupacaoFaixa(irpf);
	}

	public float getOcupacao2aFaixa(IRPF irpf) {
		return new Faixa2().getOcupacaoFaixa(irpf);
	}
	
	public float getOcupacao3aFaixa(IRPF irpf) {
		return new Faixa3().getOcupacaoFaixa(irpf);
	}
	
	public float getOcupacao4aFaixa(IRPF irpf) {
		return new Faixa4().getOcupacaoFaixa(irpf);
	}
	
	public float getOcupacao5aFaixa(IRPF irpf) {
		return new Faixa5().getOcupacaoFaixa(irpf);
	}
	
	public float getBaseDeCalculo(IRPF irpf) {
		return irpf.getTotalRendimentos() - irpf.getTotalDeducoes();
	}

}
