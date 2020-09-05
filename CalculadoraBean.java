
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Divana
 */
@ManagedBean
@SessionScoped
public class CalculadoraBean {

    Dados calculadora = new Dados();
    Dados reset = new Dados();

    //Sexo: 0 - feminino, 1 - masculino
    //Diabetes: 0 - não, 1 - sim
    //Métodos: 1 - Watson formula, 2 - Hume-Weyer formula, 3 - Bioeletrical Impedance, 4 - Mellits-Cheek formula (crianças), 5 -  0.6*peso
    
    public String Calcular() {

        switch (calculadora.getEscolhas()) {
            case 1: //Watson
                if (calculadora.getSexo() == 0) {
                    calculadora.setResultado(-2.097 + (0.1069 * calculadora.getAltura()) + (0.2466 * calculadora.getPeso()));
                } else {
                    calculadora.setResultado(2.447 - (0.09156 * calculadora.getIdade()) + (0.1074 * calculadora.getAltura()) + (0.3362 * calculadora.getPeso()));
                }
                break;
            case 2: //Hume-Weyer formula
                if (calculadora.getSexo() == 0) {
                    calculadora.setResultado((0.34454 * calculadora.getAltura()) + (0.183809 * calculadora.getPeso()) - 35.270121);
                } else {
                    calculadora.setResultado((0.194786 * calculadora.getAltura()) + (0.296785 * calculadora.getPeso()) - 14.012934);
                }
                break;
            case 3:
                if (calculadora.getSexo() == 0) {
                    if (calculadora.getDiabetes() == 0) {
                        calculadora.setResultado(calculadora.getAltura() * (0.0186104 * calculadora.getPeso() + 0.12703384) + calculadora.getPeso() * (0.00104135 * calculadora.getIdade() - 0.00067247 * calculadora.getPeso() - 0.04012056) - calculadora.getIdade() * 0.07493713);
                    } else {
                        calculadora.setResultado(calculadora.getAltura() * (0.0186104 * calculadora.getPeso() + 0.12703384) + calculadora.getPeso() * (0.00104135 * calculadora.getIdade() - 0.00067247 * calculadora.getPeso() - 0.04012056) - calculadora.getIdade() * 0.07493713 - 0 * 1.01767992 + 0.57894981);
                    }
                } else {
                    if (calculadora.getDiabetes() == 0) {
                        calculadora.setResultado(calculadora.getAltura() * (0.0186104 * calculadora.getPeso() + 0.12703384) + calculadora.getPeso() * (0.11262857 + (0.00104135 * calculadora.getIdade()) - 0.00067247 * calculadora.getPeso() - 0.04012056) - calculadora.getIdade() * (0.03486146 + 0.07493713) - 1.01767992);
                    } else {
                        calculadora.setResultado(calculadora.getAltura() * (0.0186104 * calculadora.getPeso() + 0.12703384) + calculadora.getPeso() * (0.11262857 + (0.00104135 * calculadora.getIdade()) - (0.00067247 * calculadora.getPeso() - 0.04012056) - calculadora.getIdade() * (0.03486146 + 0.07493713) - 1.01767992 + 0.57894981));
                    }
                }
                break;
            case 4: //Mellits-Cheek formula (crianças)
                if (calculadora.getSexo() == 0) {
                    if (calculadora.getAltura() < 110.8) {
                        calculadora.setResultado(0.076 + (0.507 * calculadora.getPeso()) + (0.013 * calculadora.getAltura()));
                    } else {
                        calculadora.setResultado(-10.313 + (0.252 * calculadora.getPeso()) + (0.154 * calculadora.getAltura()));
                    }
                } else {
                    if (calculadora.getAltura() < 132.7) {
                        calculadora.setResultado(-1.927 + (0.465 * calculadora.getPeso()) + (0.045 * calculadora.getAltura()));
                    } else {
                        calculadora.setResultado(-21.993 + (0.406 * calculadora.getPeso()) + (0.209 * calculadora.getAltura()));
                    }
                }
            case 5: //0.6*Peso
                calculadora.setResultado(calculadora.getPeso() * 0.6);
                break;
        }
        
        CalcDAO cd = new CalcDAO();
        cd.salvar(calculadora);

        return null;
    }

    public String Reset() {
        calculadora.setAltura(0);
        calculadora.setIdade(0);
        calculadora.setPeso(0);
        calculadora.setResultado(0);

        return null;
    }

    public Dados getCalculadora() {
        return calculadora;
    }

    public void setCalculadora(Dados calculadora) {
        this.calculadora = calculadora;
    }

    public Dados getReset() {
        return reset;
    }

    public void setReset(Dados reset) {
        this.reset = reset;
    }

}
