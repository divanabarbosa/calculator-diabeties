
/**
 *
 * @author Divana
 */
public class Dados {

    private float Altura = 0;
    private int Idade = 0;
    private int Peso = 0;
    private int Sexo; // 0 - feminino, 1 - masculino
    private int Diabetes; // 0 - não, 1 - sim
    private int Escolhas = 0; //1 - Watson formula, 2 - Hume-Weyer formula, 3 - Bioeletrical Impedance, 4 - Mellits-Cheek formula (crianças), 5 -  0.6*peso

    public int getSexo() {
        return Sexo;
    }

    public void setSexo(int Sexo) {
        this.Sexo = Sexo;
    }

    public int getDiabetes() {
        return Diabetes;
    }

    public void setDiabetes(int Diabetes) {
        this.Diabetes = Diabetes;
    }

    private double Resultado = 0; //Resultado dos cálculos

    public float getAltura() {
        return Altura;
    }

    public void setAltura(float Altura) {
        this.Altura = Altura;
    }

    public double getResultado() {
        return Resultado;
    }

    public void setResultado(double Resultado) {
        this.Resultado = Resultado;
    }

    public int getIdade() {
        return Idade;
    }

    public void setIdade(int Idade) {
        this.Idade = Idade;
    }

    public int getPeso() {
        return Peso;
    }

    public void setPeso(int Peso) {
        this.Peso = Peso;
    }

    public int getEscolhas() {
        return Escolhas;
    }

    public void setEscolhas(int Escolhas) {
        this.Escolhas = Escolhas;
    }

}
