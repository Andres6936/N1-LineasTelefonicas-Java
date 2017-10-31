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
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import edu.jabs.lineaTelefonica.mundo.Empresa;

/**
 * Clase usada para verificar que los m�todos de la clase Empresa est�n correctamente implementados.
 */
public class EmpresaTest
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase donde se har�n las pruebas.
     */
    private Empresa empresa;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye un nuevo objeto de la clase empresa vac�a.
     */
    private void setupEscenario1( )
    {
        empresa = new Empresa( );
    }

    /**
     * Escenario 2: Construye un nuevo objeto de la clase empresa con llamadas.
     */
    private void setupEscenario2( )
    {
        empresa = new Empresa( );

        empresa.agregarLlamadaLocalLinea1( 1 );
        empresa.agregarLlamadaLargaDistanciaLinea1( 2 );
        empresa.agregarLlamadaCelularLinea1( 3 );

        empresa.agregarLlamadaLocalLinea2( 10 );
        empresa.agregarLlamadaLargaDistanciaLinea2( 20 );
        empresa.agregarLlamadaCelularLinea2( 30 );

        empresa.agregarLlamadaLocalLinea2( 100 );
        empresa.agregarLlamadaLargaDistanciaLinea2( 200 );
        empresa.agregarLlamadaCelularLinea2( 300 );
    }

    /**
     * Prueba 1: M�todo que se encarga de verificar el m�todo inicializar.<br>
     * <b> M�todos a probar: </b> <br>
     * Empresa<br>
     * darLinea1<br>
     * darLinea2<br>
     * darLinea3<br>
     * <b> Casos de prueba: </b> <br>
     * 1. La empresa no tiene llamadas en ninguna l�nea.
     */
    @Test
    public void testInicializacion( )
    {
        setupEscenario1( );
        assertNotNull( "La l�nea telef�nica 1 debe estar inicializada", empresa.darLinea1( ) );
        assertNotNull( "La l�nea telef�nica 2 debe estar inicializada", empresa.darLinea2( ) );
        assertNotNull( "La l�nea telef�nica 3 debe estar inicializada", empresa.darLinea3( ) );
    }

    /**
     * Prueba 2: M�todo que se encarga de verificar el m�todo agregarLlamadaLocalLinea1.<br>
     * <b> M�todos a probar: </b> <br>
     * agregarLlamadaLocalLinea1<br>
     * darLinea1<br>
     * <b> Casos de prueba: </b> <br>
     * 1. La empresa no tiene llamadas en ninguna l�nea.
     */
    @Test
    public void testAgregarLlamadaLocalLinea1( )
    {
        setupEscenario1( );
        empresa.agregarLlamadaLocalLinea1( 10 );
        assertEquals( "La llamada no qued� registrada", 1, empresa.darLinea1( ).darNumeroLlamadas( ) );
    }

    /**
     * Prueba 3: M�todo que se encarga de verificar el m�todo agregarLlamadaLocalLinea2.<br>
     * <b> M�todos a probar: </b> <br>
     * agregarLlamadaLocalLinea2<br>
     * darLinea2<br>
     * <b> Casos de prueba: </b> <br>
     * Se agrega una llamada local a la l�nea 2 de la empresa.
     */
    @Test
    public void testAgregarLlamadaLocalLinea2( )
    {
        setupEscenario1( );
        empresa.agregarLlamadaLocalLinea2( 10 );
        assertEquals( "La llamada no qued� registrada", 1, empresa.darLinea2( ).darNumeroLlamadas( ) );
    }

    /**
     * Prueba 4: M�todo que se encarga de verificar el m�todo agregarLlamadaLocalLinea3.<br>
     * <b> M�todos a probar: </b> <br>
     * agregarLlamadaLocalLinea3<br>
     * darLinea3<br>
     * <b> Casos de prueba: </b> <br>
     * Se agrega una llamada local a la l�nea 3 de la empresa.
     */
    @Test
    public void testAgregarLlamadaLocalLinea3( )
    {
        setupEscenario1( );
        empresa.agregarLlamadaLocalLinea3( 10 );
        assertEquals( "La llamada no qued� registrada", 1, empresa.darLinea3( ).darNumeroLlamadas( ) );
    }

    /**
     * Prueba 5: M�todo que se encarga de verificar el m�todo agregarLlamadaLargaDistanciaLinea1.<br>
     * <b> M�todos a probar: </b> <br>
     * agregarLlamadaLargaDistanciaLinea1<br>
     * darLinea1<br>
     * <b> Casos de prueba: </b> <br>
     * 1. La empresa no tiene llamadas en ninguna l�nea.
     */
    @Test
    public void testAgregarLlamadaLargaDistanciaLinea1( )
    {
        setupEscenario1( );
        empresa.agregarLlamadaLargaDistanciaLinea1( 10 );
        assertEquals( "La llamada no qued� registrada", 1, empresa.darLinea1( ).darNumeroLlamadas( ) );
    }

    /**
     * Prueba 6: M�todo que se encarga de verificar el m�todo agregarLlamadaLargaDistanciaLinea2.<br>
     * <b> M�todos a probar: </b> <br>
     * agregarLlamadaLargaDistanciaLinea2<br>
     * darLinea2<br>
     * <b> Casos de prueba: </b> <br>
     * 1. La empresa no tiene llamadas en ninguna l�nea.
     */
    @Test
    public void testAgregarLlamadaLargaDistanciaLinea2( )
    {
        setupEscenario1( );
        empresa.agregarLlamadaLargaDistanciaLinea2( 10 );
        assertEquals( "La llamada no qued� registrada", 1, empresa.darLinea2( ).darNumeroLlamadas( ) );
    }

    /**
     * Prueba 7: M�todo que se encarga de verificar el m�todo agregarLlamadaLargaDistanciaLinea3.<br>
     * <b> M�todos a probar: </b> <br>
     * agregarLlamadaLargaDistanciaLinea3<br>
     * darLinea3<br>
     * <b> Casos de prueba: </b> <br>
     * 1. La empresa no tiene llamadas en ninguna l�nea.
     */
    @Test
    public void testAgregarLlamadaLargaDistanciaLinea3( )
    {
        setupEscenario1( );
        empresa.agregarLlamadaLargaDistanciaLinea3( 10 );
        assertEquals( "La llamada no qued� registrada", 1, empresa.darLinea3( ).darNumeroLlamadas( ) );
    }

    /**
     * Prueba 8: M�todo que se encarga de verificar el m�todo agregarLlamadaCelularLinea1.<br>
     * <b> M�todos a probar: </b> <br>
     * agregarLlamadaCelularLinea1<br>
     * darLinea1<br>
     * <b> Casos de prueba: </b> <br>
     * 1. La empresa no tiene llamadas en ninguna l�nea.
     */
    @Test
    public void testAgregarCelularDistanciaLinea1( )
    {
        setupEscenario1( );
        empresa.agregarLlamadaCelularLinea1( 10 );
        assertEquals( "La llamada no qued� registrada", 1, empresa.darLinea1( ).darNumeroLlamadas( ) );
    }

    /**
     * Prueba 9: M�todo que se encarga de verificar el m�todo agregarLlamadaCelularLinea2.<br>
     * <b> M�todos a probar: </b> <br>
     * agregarLlamadaCelularLinea2<br>
     * darLinea2<br>
     * <b> Casos de prueba: </b> <br>
     * 1. La empresa no tiene llamadas en ninguna l�nea.
     */
    @Test
    public void testAgregarCelularDistanciaLinea2( )
    {
        setupEscenario1( );
        empresa.agregarLlamadaCelularLinea2( 10 );
        assertEquals( "La llamada no qued� registrada", 1, empresa.darLinea2( ).darNumeroLlamadas( ) );
    }

    /**
     * Prueba 10: M�todo que se encarga de verificar el m�todo agregarLlamadaCelularLinea3.<br>
     * <b> M�todos a probar: </b> <br>
     * agregarLlamadaCelularLinea3<br>
     * darLinea3<br>
     * <b> Casos de prueba: </b> <br>
     * 1. La empresa no tiene llamadas en ninguna l�nea.
     */
    @Test
    public void testAgregarCelularDistanciaLinea3( )
    {
        setupEscenario1( );
        empresa.agregarLlamadaCelularLinea3( 10 );
        assertEquals( "La llamada no qued� registrada", 1, empresa.darLinea3( ).darNumeroLlamadas( ) );
    }

    /**
     * Prueba 11: M�todo que se encarga de verificar el m�todo darTotalNumeroLlamadas.<br>
     * <b> M�todos a probar: </b> <br>
     * darTotalNumeroLlamadas<br>
     * <b> Casos de prueba: </b> <br>
     * 1. La empresa tiene llamadas en las 3 l�neas telef�nicas.
     */
    @Test
    public void testDarTotalLlamadas( )
    {
        setupEscenario2( );
        assertEquals( "El numero de llamadas debe ser 9", 9, empresa.darTotalNumeroLlamadas( ) );
    }

    /**
     * Prueba 12: M�todo que se encarga de verificar el m�todo darTotalMinutos.<br>
     * <b> M�todos a probar: </b> <br>
     * darTotalMinutos<br>
     * <b> Casos de prueba: </b> <br>
     * 1. La empresa tiene llamadas en las 3 l�neas telef�nicas.
     */
    @Test
    public void testDarTotalMinutos( )
    {
        setupEscenario2( );
        assertEquals( "El total de minutos debe ser 666", 666, empresa.darTotalMinutos( ) );
    }

    /**
     * Prueba 13: M�todo que se encarga de verificar el m�todo darTotalCostoLlamadas.<br>
     * <b> M�todos a probar: </b> <br>
     * darTotalCostoLlamadas<br>
     * <b> Casos de prueba: </b> <br>
     * 1. La empresa tiene llamadas en las 3 l�neas telef�nicas.
     */
    public void testDarTotalCosto( )
    {
        setupEscenario2( );
        assertEquals( "El costo es inv�lido. Debe ser $ 420.912", 420912, empresa.darTotalCostoLlamadas( ), 0.001 );
    }

    /**
     * Prueba 14: M�todo que se encarga de verificar el m�todo darCostoPromedioMinuto.<br>
     * <b> M�todos a probar: </b> <br>
     * darCostoPromedioMinuto<br>
     * <b> Casos de prueba: </b> <br>
     * 1. La empresa tiene llamadas en las 3 l�neas telef�nicas.
     */
    @Test
    public void testDarCostoPromedio( )
    {
        setupEscenario2( );
        assertEquals( "El costo promedio es inv�lido. Debe ser $632", 632, empresa.darCostoPromedioMinuto( ), 0.001 );
    }

    /**
     * Prueba 14: M�todo que se encarga de verificar el m�todo reiniciar.<br>
     * <b> M�todos a probar: </b> <br>
     * reiniciar<br>
     * darTotalNumeroLlamadas<br>
     * darTotalMinutos<br>
     * darTotalCostoLlamadas<br>
     * <b> Casos de prueba: </b> <br>
     * 1. La empresa tiene llamadas en las 3 l�neas telef�nicas.
     */
    @Test
    public void testReiniciar( )
    {
        setupEscenario2( );
        empresa.reiniciar( );
        assertEquals( "El total de llamadas debe ser cero", 0, empresa.darTotalNumeroLlamadas( ) );
        assertEquals( "El total de minutos debe ser cero", 0, empresa.darTotalMinutos( ) );
        assertEquals( "El costo total de llamadas debe ser cero", 0, empresa.darTotalCostoLlamadas( ), 0.01 );
    }

}