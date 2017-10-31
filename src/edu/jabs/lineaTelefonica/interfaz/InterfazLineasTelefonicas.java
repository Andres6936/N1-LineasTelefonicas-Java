/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  Universidad Santiago de Cali (Cali - Colombia)
  Departamento de Ingeniería de Sistemas y Computación
  Licenciado bajo el esquema Academic Free License version 2.1

  Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
  Ejercicio: N1-LineaTelefonica-Java
  Autor: Joan Andrés Buriticá Salazar
  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package edu.jabs.lineaTelefonica.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import edu.jabs.lineaTelefonica.mundo.Empresa;

/**
 * Ventana principal de la aplicaci�n.
 */
public class InterfazLineasTelefonicas extends JFrame
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase principal del mundo.
     */
    private Empresa empresa;

    /**
     * Panel con la imagen.
     */
    private PanelImagen panelImagen;

    /**
     * Panel con los totales.
     */
    private PanelTotales panelTotales;

    /**
     * Panel de la l�nea 1.
     */
    private PanelLineaTelefonica panelLinea1;

    /**
     * Panel de la l�nea 2.
     */
    private PanelLineaTelefonica panelLinea2;

    /**
     * Panel de la l�nea 3.
     */
    private PanelLineaTelefonica panelLinea3;

    /**
     * Panel con las opciones.
     */
    private PanelOpciones panelOpciones;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor de la interfaz. <b>post: </b> Se inicializ� la interfaz principal y sus paneles.<br>
     */
    public InterfazLineasTelefonicas( )
    {
        // Crea la clase principal
        empresa = new Empresa( );

        // Construye la forma
        // organizar el panel principal
        getContentPane( ).setLayout( new BorderLayout( ) );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setTitle( "Manejo l�neas telef�nicas" );

        // Creaci�n de los paneles aqu�
        panelImagen = new PanelImagen( );
        getContentPane( ).add( panelImagen, BorderLayout.NORTH );

        JPanel panelCentrar = new JPanel( );
        panelCentrar.setLayout( new BorderLayout( ) );
        getContentPane( ).add( panelCentrar, BorderLayout.CENTER );

        JPanel panelContenedor = new JPanel( );
        panelContenedor.setLayout( new GridLayout( 1, 3 ) );
        panelCentrar.add( panelContenedor, BorderLayout.CENTER );

        // Agrega los paneles al panel contenedor
        panelLinea1 = new PanelLineaTelefonica( this, 1 );
        panelContenedor.add( panelLinea1 );
        panelLinea2 = new PanelLineaTelefonica( this, 2 );
        panelContenedor.add( panelLinea2 );
        panelLinea3 = new PanelLineaTelefonica( this, 3 );
        panelContenedor.add( panelLinea3 );

        panelTotales = new PanelTotales( );
        panelCentrar.add( panelTotales, BorderLayout.SOUTH );

        // Panel extensiones
        panelOpciones = new PanelOpciones( this );
        getContentPane( ).add( panelOpciones, BorderLayout.SOUTH );

        setSize( 600, 610 );
        setResizable( false );
        setLocationRelativeTo( null );
        ;
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Agrega una llamada a una l�nea telef�nica. <br>
     * @param pNumeroLinea N�mero de la l�nea telef�nica. pNumeroLinea>0 && pNumeroLinea<4.
     */
    public void agregarLlamada( int pNumeroLinea )
    {
        String minutos = JOptionPane.showInputDialog( this, "N�mero de minutos hablados:", "Agregar llamada", JOptionPane.QUESTION_MESSAGE );
        try
        {
            if( minutos != null )
            {
                int min = Integer.parseInt( minutos );
                if( min <= 0 )
                {
                    JOptionPane.showMessageDialog( this, "El n�mero de minutos debe ser mayor a cero", "Agregar llamada", JOptionPane.ERROR_MESSAGE );
                    return;
                }
                Object[] possibilities = { "Local", "Larga distancia", "Celular" };
                String tipo = ( String )JOptionPane.showInputDialog( this, "Tipo de llamada:", "Tipo", JOptionPane.QUESTION_MESSAGE, null, possibilities, "Local" );
                if( tipo != null )
                {
                    if( pNumeroLinea == 1 )
                    {
                        if( "Local".equals( tipo ) )
                        {
                            empresa.agregarLlamadaLocalLinea1( min );
                        }
                        else if( "Larga distancia".equals( tipo ) )
                        {
                            empresa.agregarLlamadaLargaDistanciaLinea1( min );
                        }
                        else if( "Celular".equals( tipo ) )
                        {
                            empresa.agregarLlamadaCelularLinea1( min );
                        }
                    }
                    else if( pNumeroLinea == 2 )
                    {
                        if( "Local".equals( tipo ) )
                        {
                            empresa.agregarLlamadaLocalLinea2( min );
                        }
                        else if( "Larga distancia".equals( tipo ) )
                        {
                            empresa.agregarLlamadaLargaDistanciaLinea2( min );
                        }
                        else if( "Celular".equals( tipo ) )
                        {
                            empresa.agregarLlamadaCelularLinea2( min );
                        }
                    }
                    else if( pNumeroLinea == 3 )
                    {
                        if( "Local".equals( tipo ) )
                        {
                            empresa.agregarLlamadaLocalLinea3( min );
                        }
                        else if( "Larga distancia".equals( tipo ) )
                        {
                            empresa.agregarLlamadaLargaDistanciaLinea3( min );
                        }
                        else if( "Celular".equals( tipo ) )
                        {
                            empresa.agregarLlamadaCelularLinea3( min );
                        }
                    }
                    actualizar( );
                }
            }
        }
        catch( NumberFormatException e )
        {
            JOptionPane.showMessageDialog( this, "El n�mero de minutos es inv�lido", "Agregar llamada", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Actualiza la visualizaci�n de la interfaz. <br>
     * <b>post: </b> Se actualiz� la informaci�n de la interfaz.<br>
     */
    private void actualizar( )
    {
        panelTotales.actualizar( empresa.darTotalCostoLlamadas( ), empresa.darTotalNumeroLlamadas( ), empresa.darTotalMinutos( ), empresa.darCostoPromedioMinuto( ) );
        panelLinea1.actualizar( empresa.darLinea1( ).darCostoLlamadas( ), empresa.darLinea1( ).darNumeroLlamadas( ), empresa.darLinea1( ).darNumeroMinutos( ) );
        panelLinea2.actualizar( empresa.darLinea2( ).darCostoLlamadas( ), empresa.darLinea2( ).darNumeroLlamadas( ), empresa.darLinea2( ).darNumeroMinutos( ) );
        panelLinea3.actualizar( empresa.darLinea3( ).darCostoLlamadas( ), empresa.darLinea3( ).darNumeroLlamadas( ), empresa.darLinea3( ).darNumeroMinutos( ) );
    }

    /**
     * Reinicia las l�neas telef�nicas. <b>post: </b> Se reinici� las l�neas telef�nicas.
     */
    public void reiniciar( )
    {
        empresa.reiniciar( );
        actualizar( );
    }

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * M�todo para la extensi�n 1.
     */
    public void reqFuncOpcion1( )
    {
        String resultado = empresa.metodo1( );
        actualizar( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * M�todo para la extensi�n 2.
     */
    public void reqFuncOpcion2( )
    {
        String resultado = empresa.metodo2( );
        actualizar( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * M�todo ejecuta la aplicaci�n, creando una nueva interfaz.
     * @param pArgs Argumentos de el llamado. No se requiere ninguno.
     */
    public static void main( String[] pArgs )
    {
        // Unifica la interfaz para Mac y para Windows.
        try
        {
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );
        }
        catch( Exception e )
        {
        }

        InterfazLineasTelefonicas interfaz = new InterfazLineasTelefonicas( );
        interfaz.setVisible( true );
    }

}