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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * Panel con la informaci�n de una l�nea telef�nica.
 */
public class PanelLineaTelefonica extends JPanel implements ActionListener
{

    //-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------

    /**
     * Comando para agregar una llamada.
     */
    private static final String AGREGAR = "AGREGAR";

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Ventana principal de la aplicaci�n.
     */
    private InterfazLineasTelefonicas principal;

    /**
     * N�mero del l�nea telef�nica.
     */
    private int numeroLinea;

    //-----------------------------------------------------------------
    // Atributos de Interfaz
    //-----------------------------------------------------------------

    /**
     * Etiqueta con la imagen del tel�fono.
     */
    private JLabel etiquetaImagen;

    /**
     * Etiqueta costo de llamadas.
     */
    private JLabel etiquetaCosto;

    /**
     * Etiqueta n�mero de llamadas.
     */
    private JLabel etiquetaNumeroLlamadas;

    /**
     * Etiqueta minutos consumidos.
     */
    private JLabel etiquetaMinutos;
    
    /**
     * Campo de texto para el n�mero de llamadas.
     */
    private JTextField txtNumeroLlamadas;
    
    /**
     * Campo de texto para los minutos consumidos
     */
    private JTextField txtMinutos;

    /**
     * Bot�n Agregar llamada.
     */
    private JButton btnAgregar;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Constructor del panel.
     * <b>post: </b> Se construy� el panel.
     * @param pPrincipal Ventana principal. pPrincipal != null.
     * @param pNumeroLinea N�mero de la l�nea. pNumeroLinea>0 && pNumeroLinea<4.
     */
    public PanelLineaTelefonica( InterfazLineasTelefonicas pPrincipal, int pNumeroLinea )
    {
        principal = pPrincipal;
        numeroLinea = pNumeroLinea;
        setBorder( new TitledBorder( "L�nea " + numeroLinea ) );
        setLayout( new GridLayout( 2, 1 ) );
        setPreferredSize( new Dimension( 260, 220 ) );

        //Etiqueta de Imagen
        ImageIcon icono = new ImageIcon( "data/Linea" + numeroLinea + ".png" );
        etiquetaImagen = new JLabel( "" );
        etiquetaImagen.setIcon( icono );
        etiquetaImagen.setHorizontalAlignment( JLabel.CENTER );

        //Etiqueta Costo
        etiquetaCosto = new JLabel( formatearValor( 0 ) );
        etiquetaCosto.setForeground( Color.BLUE.darker( ) );
        etiquetaCosto.setFont( new Font( "Times New Roman", Font.BOLD, 18 ) );
        etiquetaCosto.setHorizontalAlignment( JLabel.CENTER );

        //Etiqueta N�mero de llamadas
        etiquetaNumeroLlamadas = new JLabel( "N�mero llamadas: " );

        //Etiqueta Total de Minutos
        etiquetaMinutos = new JLabel( "N�mero minutos: " );

        //Campo de texto N�mero de llamadas
        txtNumeroLlamadas = new JTextField( 4 );
        txtNumeroLlamadas.setEditable( false );
        txtNumeroLlamadas.setText( "0" );
        
        //Campo de texto Total de Minutos
        txtMinutos = new JTextField( 4 );
        txtMinutos.setEditable( false );
        txtMinutos.setText( "0" );
        
        //Bot�n Agregar llamada
        btnAgregar = new JButton( "Agregar llamada" );
        btnAgregar.setPreferredSize( new Dimension( 150, 25 ) );
        btnAgregar.setActionCommand( AGREGAR );
        btnAgregar.addActionListener( this );

        //Organizaci�n.
        JPanel panelDatos = new JPanel( new GridLayout( 4, 1 ) );
        JPanel panelLlamadas = new JPanel( new BorderLayout( ) );
        JPanel panelMinutos = new JPanel( new BorderLayout( ) );
        
        panelDatos.setBorder( new EmptyBorder( 8, 0, 8, 0 ) );
        panelDatos.add( etiquetaCosto );
        panelDatos.add( panelLlamadas );
        panelDatos.add( panelMinutos );
        panelDatos.add( btnAgregar );
  
        panelLlamadas.add( etiquetaNumeroLlamadas, BorderLayout.CENTER );
        panelLlamadas.add( txtNumeroLlamadas, BorderLayout.EAST );
        panelMinutos.add( etiquetaMinutos, BorderLayout.CENTER );
        panelMinutos.add( txtMinutos, BorderLayout.EAST );
        
        add ( etiquetaImagen );
        add ( panelDatos );
    }

    //-----------------------------------------------------------------
    // M�todos
    //-----------------------------------------------------------------

    /**
     * Actualiza la visualizaci�n de la informaci�n.
     * @param pCostoLlamadas Costo total de las llamadas realizadas en esta l�nea. pCostoLlamadas>=0. 
     * @param pTotalLLamadas Total n�mero de llamadas. pTotalLlamadas>=0.
     * @param pTotalMinutos Total n�mero de minutos. pTotalMinutos>=0.
     */
    public void actualizar( double pCostoLlamadas, int pTotalLLamadas, int pTotalMinutos)
    {
        etiquetaCosto.setText( formatearValor( pCostoLlamadas) );
        txtNumeroLlamadas.setText( formatearValorEntero( pTotalLLamadas ) );
        txtMinutos.setText( formatearValorEntero( pTotalMinutos ) );
    }

    /**
     * Formatea un valor num�rico para presentar en la interfaz.
     * @param pValor Valor num�rico a ser formateado. pValor>0.
     * @return Cadena con el valor formateado con puntos y signos.
     */
    private String formatearValor( double pValor )
    {
        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( "$ ###,###.##" );
        df.setMinimumFractionDigits( 2 );
        return df.format( pValor );
    }

    /**
     * Formatea un valor num�rico para presentar en la interfaz <br>
     * @param pValor Valor num�rico a ser formateado. pValor >0.
     * @return Retorna una cadena con el valor formateado con puntos y signos.
     */
    private String formatearValorEntero( int pValor )
    {
        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( " ###,###" );
        df.setMinimumFractionDigits( 0 );
        return df.format( pValor );
    }

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Evento de click sobre un bot�n. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        if( AGREGAR.equals( pEvento.getActionCommand( ) ) )
        {
            principal.agregarLlamada( numeroLinea );
        }
    }

}
