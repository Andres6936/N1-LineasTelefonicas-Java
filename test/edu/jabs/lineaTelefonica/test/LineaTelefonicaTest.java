/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  Universidad Santiago de Cali (Cali - Colombia)
  Departamento de Ingeniería de Sistemas y Computación
  Licenciado bajo el esquema Academic Free License version 2.1

  Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
  Ejercicio: N1-LineaTelefonica-Java
  Autor: Joan Andrés Buriticá Salazar
  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package edu.jabs.lineaTelefonica.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.jabs.lineaTelefonica.mundo.LineaTelefonica;

/**
 * Clase usada para verificar que los m�todos de la clase LineaTelefonica est�n correctamente implementados.
 */
public class LineaTelefonicaTest 
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se har�n las pruebas.
     */
    private LineaTelefonica linea;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye una nueva l�nea telef�nica vac�a.
     */
    private void setupEscenario1( )
    {
        linea = new LineaTelefonica( );
    }

    /**
     * Prueba 1: M�todo que se encarga de verificar el m�todo agregarLlamadaCelular. <br>
     * <b> M�todos a probar: </b> <br>
     * agregarLlamadaCelular<br>
     * darNumeroLlamadas<br>
     * darNumeroMinutos<br>
     * darCostoLlamadas<br>
     * <b> Casos de prueba: </b> <br>
     * 1. No hay llamadas el la l�nea.
     */
    @Test
    public void testAgregarLlamadaCelular( )
    {
        setupEscenario1( );
        linea.agregarLlamadaCelular( 10 );
        assertEquals( "El n�mero de llamadas debe ser 1", 1, linea.darNumeroLlamadas( ) );
        assertEquals( "El n�mero de minutos debe ser 10", 10, linea.darNumeroMinutos( ) );
        assertEquals( "El costo debe ser $9.990", 9990, linea.darCostoLlamadas( ), 0.001 );
    }

    /**
     * Prueba 2: M�todo que se encarga de verificar el m�todo agregarLlamadaLocal. <br>
     * <b> M�todos a probar: </b> <br>
     * agregarLlamadaLocal<br>
     * darNumeroLlamadas<br>
     * darNumeroMinutos<br>
     * darCostoLlamadas<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Hay una llamada en la l�nea.
     */
    @Test
    public void testAgregarLlamadaLocal( )
    {
        setupEscenario1( );
        linea.agregarLlamadaLocal( 5 );
        assertEquals( "El n�mero de llamadas debe ser 1", 1, linea.darNumeroLlamadas( ) );
        assertEquals( "El n�mero de minutos debe ser 5", 5, linea.darNumeroMinutos( ) );
        assertEquals( "El costo debe ser $175", 175, linea.darCostoLlamadas( ), 0.001 );
    }

    /**
     * Prueba 3: M�todo que se encarga de verificar el m�todo agregarLlamadaLargaDistancia.<br>
     * <b> M�todos a probar: </b> <br>
     * agregarLlamadaLargaDistancia<br>
     * darNumeroLlamadas<br>
     * darNumeroMinutos<br>
     * darCostoLlamadas<br>
     * <b> Casos de prueba: </b> <br>
     * 1. No hay llamadas el la l�nea.
     */
    @Test
    public void testAgregarLlamadaLargaDistancia( )
    {
        setupEscenario1( );
        linea.agregarLlamadaLargaDistancia( 7 );
        assertEquals( "El n�mero de llamadas debe ser 1", 1, linea.darNumeroLlamadas( ) );
        assertEquals( "El n�mero de minutos debe ser 5", 7, linea.darNumeroMinutos( ) );
        assertEquals( "El costo debe ser $2.660", 2660, linea.darCostoLlamadas( ), 0.001 );
    }

    /**
     * Prueba 4: M�todo que se encarga de verificar el m�todo reiniciar. <br>
     * <b> M�todos a probar: </b> <br>
     * reiniciar<br>
     * agregarLlamadaLargaDistancia<br>
     * darNumeroLlamadas<br>
     * darNumeroMinutos<br>
     * darCostoLlamadas<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Hay una llamada en la l�nea.
     */
    @Test
    public void testReiniciar( )
    {
        setupEscenario1( );
        linea.agregarLlamadaLargaDistancia( 7 );
        linea.reiniciar( );
        assertEquals( "El n�mero de llamadas debe ser 0", 0, linea.darNumeroLlamadas( ) );
        assertEquals( "El n�mero de minutos debe ser 0", 0, linea.darNumeroMinutos( ) );
        assertEquals( "El costo debe ser $0.0", 0, linea.darCostoLlamadas( ), 0.001 );
    }

}
