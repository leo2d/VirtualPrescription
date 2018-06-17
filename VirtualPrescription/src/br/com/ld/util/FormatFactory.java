/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ld.util;

/**
 *
 * @author Leonardo
 */

import java.text.DecimalFormat;
import java.util.Date;
import java.text.SimpleDateFormat;

public class FormatFactory {
    
    public static String formatDate(Date data){
    
        SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");
        
        return  sdf.format(data);
    }
    
    public static String formatDecimal(double valor){
        DecimalFormat df = new DecimalFormat("#0.00");
        
        return df.format(valor);
    }
}
