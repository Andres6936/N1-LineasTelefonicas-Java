/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  Universidad Santiago de Cali (Cali - Colombia)
  Departamento de Ingeniería de Sistemas y Computación
  Licenciado bajo el esquema Academic Free License version 2.1

  Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
  Ejercicio: N1-LineaTelefonica-Java
  Autor: Joan Andrés Buriticá Salazar
  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package edu.jabs.lineaTelefonica.mundo;

/**
 * Clase que representa una l�nea telef�nica.
 */
public class LineaTelefonica
{

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * N�mero de llamadas realizadas.
     */
    private int numeroLlamadas;

    /**
     * N�mero de minutos consumidos.
     */
    private int numeroMinutos;

    /**
     * Costo total de las llamadas.
     */
    private double costoLlamadas;

    //-----------------------------------------------------------------
    // M�todos
    //-----------------------------------------------------------------

    /**
     * Inicializa la l�nea telef�nica. <br>
     * <b>post: </b> La l�nea se inicializ� con valores en cero.
     */
    public LineaTelefonica( )
    {
        numeroLlamadas = 0;
        numeroMinutos = 0;
        costoLlamadas = 0;
    }

    /**
     * Retorna el costo total de las llamadas realizadas.
     * @return Costo total de las llamadas realizadas.
     */
    public double darCostoLlamadas( )
    {
        return costoLlamadas;
    }

    /**
     * Retorna el n�mero de llamadas realizadas por esta l�nea.
     * @return N�mero de llamadas realizadas por esta l�nea.
     */
    public int darNumeroLlamadas( )
    {
        return numeroLlamadas;
    }

    /**
     * Retorna el n�mero de minutos consumidos.
     * @return N�mero de minutos consumidos.
     */
    public int darNumeroMinutos( )
    {
        return numeroMinutos;
    }

    /**
	 * Reinicia la l�nea telef�nica, dejando todos sus valores en cero.<br>
	 * <b> post: </b> El n�mero de llamadas, n�mero de minutos y costo de llamadas son 0.
	 */
	public void reiniciar( )
	{
        numeroLlamadas = 0;
        numeroMinutos = 0;
        costoLlamadas = 0;
	}

	/**
     * Agrega una llamada local a la l�nea telef�nica <br>
     * <b>post: </b> Se increment� en 1 numeroDeLlamadas, se incremento numeroDeMinutos en minutos, costoLlamadas aument� en ( minutos * 35 ).
     * @param pMinutos N�mero de minutos de la llamada. pMinutos >0.
     */
    public void agregarLlamadaLocal( int pMinutos )
    {
        //Una llamada m�s
        numeroLlamadas = numeroLlamadas + 1;
        //
        //Suma los minutos consumidos
        numeroMinutos = numeroMinutos + pMinutos;
        //
        //Suma el costo (costo por minuto: 35 pesos)
        costoLlamadas = costoLlamadas + ( pMinutos * 35 );
    }

    /**
     * Agrega una llamada de larga distancia a la l�nea telef�nica <br>
     * <b>post: </b> Se increment� en 1 numeroDeLlamadas, se incremento numeroDeMinutos en minutos, costoLlamadas aument� en ( minutos * 380 )
     * @param pMinutos N�mero de minutos de la llamada. pMinutos >0.
     */
    public void agregarLlamadaLargaDistancia( int pMinutos )
    {
        numeroLlamadas += 1;
        numeroMinutos += pMinutos;
        costoLlamadas += pMinutos * 380;
    }

    /**
     * Agrega una llamada a celular a la l�nea telef�nica <br>
     * <b>post: </b> Se increment� en 1 numeroDeLlamadas, se incremento numeroDeMinutos en minutos, costoLlamadas aument� en ( minutos * 999 )
     * @param pMinutos N�mero de minutos de la llamada. pMinutos >0.
     */
    public void agregarLlamadaCelular( int pMinutos )
    {
        numeroLlamadas += 1;
        numeroMinutos += pMinutos;
        costoLlamadas += pMinutos * 999;
    }

}