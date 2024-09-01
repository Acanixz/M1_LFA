/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package buscapadraoweb;

import buscaweb.CapturaRecursosWeb;
import java.util.ArrayList;

/**
 *
 * @author Santiago
 */
public class Main {

    // busca char em vetor e retorna indice
    public static int get_char_ref (char[] vet, char ref ){
        for (int i=0; i<vet.length; i++ ){
            if (vet[i] == ref){
                return i;
            }
        }
        return -1;
    }

    // busca string em vetor e retorna indice
    public static int get_string_ref (String[] vet, String ref ){
        for (int i=0; i<vet.length; i++ ){
            if (vet[i].equals(ref)){
                return i;
            }
        }
        return -1;
    }

    //retorna o próximo estado, dado o estado atual e o símbolo lido
    public static int proximo_estado(char[] alfabeto, int[][] matriz,int estado_atual,char simbolo){
        int simbol_indice = get_char_ref(alfabeto, simbolo);
        if (simbol_indice != -1){
            return matriz[estado_atual][simbol_indice];
        }else{
            return -1;
        }
    }

    /*
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //instancia e usa objeto que captura código-fonte de páginas Web
        CapturaRecursosWeb crw = new CapturaRecursosWeb();
        crw.getListaRecursos().add("https://www.univali.br/");
        crw.getListaRecursos().add("https://pt.wikipedia.org/wiki/IPv4");
        crw.getListaRecursos().add("https://pt.wikipedia.org/wiki/Endere%C3%A7o_IP");
        ArrayList<String> listaCodigos = crw.carregarRecursos();

        //mapa do alfabeto
        char[] alfabeto = new char[11];
        alfabeto[0] = '0';
        alfabeto[1] = '1';
        alfabeto[2] = '2';
        alfabeto[3] = '3';
        alfabeto[4] = '4';
        alfabeto[5] = '5';
        alfabeto[6] = '6';
        alfabeto[7] = '7';
        alfabeto[8] = '8';
        alfabeto[9] = '9';
        alfabeto[10] = '.';

        //mapa de estados
        String[] estados = new String[28];
        for (int i=0; i<estados.length; i++){
            estados[i] = "Q" + i;
        }

        String estado_inicial = "Q0";

        //estados finais
        String[] estados_finais = new String[6];
        int quandoComecaEstadosFinais = 22;
        for (int i = quandoComecaEstadosFinais; i< (quandoComecaEstadosFinais + estados_finais.length); i++){
            estados_finais[i - quandoComecaEstadosFinais] = "Q" + i;
        }

        //tabela de transição de AFD para reconhecimento números de dois dígitos
        int[][] matriz = new int[28][11];
//transições do Q0
        matriz[get_string_ref(estados, "Q0")][get_char_ref(alfabeto, '0')] = get_string_ref(estados, "Q1");
        matriz[get_string_ref(estados, "Q0")][get_char_ref(alfabeto, '1')] = get_string_ref(estados, "Q2");
        matriz[get_string_ref(estados, "Q0")][get_char_ref(alfabeto, '2')] = get_string_ref(estados, "Q4");
        matriz[get_string_ref(estados, "Q0")][get_char_ref(alfabeto, '3')] = get_string_ref(estados, "Q3");
        matriz[get_string_ref(estados, "Q0")][get_char_ref(alfabeto, '4')] = get_string_ref(estados, "Q3");
        matriz[get_string_ref(estados, "Q0")][get_char_ref(alfabeto, '5')] = get_string_ref(estados, "Q3");
        matriz[get_string_ref(estados, "Q0")][get_char_ref(alfabeto, '6')] = get_string_ref(estados, "Q3");
        matriz[get_string_ref(estados, "Q0")][get_char_ref(alfabeto, '7')] = get_string_ref(estados, "Q3");
        matriz[get_string_ref(estados, "Q0")][get_char_ref(alfabeto, '8')] = get_string_ref(estados, "Q3");
        matriz[get_string_ref(estados, "Q0")][get_char_ref(alfabeto, '9')] = get_string_ref(estados, "Q3");
        matriz[get_string_ref(estados, "Q0")][get_char_ref(alfabeto, '.')] = -1;
//transições do Q1
        matriz[get_string_ref(estados, "Q1")][get_char_ref(alfabeto, '0')] = -1;
        matriz[get_string_ref(estados, "Q1")][get_char_ref(alfabeto, '1')] = -1;
        matriz[get_string_ref(estados, "Q1")][get_char_ref(alfabeto, '2')] = -1;
        matriz[get_string_ref(estados, "Q1")][get_char_ref(alfabeto, '3')] = -1;
        matriz[get_string_ref(estados, "Q1")][get_char_ref(alfabeto, '4')] = -1;
        matriz[get_string_ref(estados, "Q1")][get_char_ref(alfabeto, '5')] = -1;
        matriz[get_string_ref(estados, "Q1")][get_char_ref(alfabeto, '6')] = -1;
        matriz[get_string_ref(estados, "Q1")][get_char_ref(alfabeto, '7')] = -1;
        matriz[get_string_ref(estados, "Q1")][get_char_ref(alfabeto, '8')] = -1;
        matriz[get_string_ref(estados, "Q1")][get_char_ref(alfabeto, '9')] = -1;
        matriz[get_string_ref(estados, "Q1")][get_char_ref(alfabeto, '.')] = get_string_ref(estados, "Q7");
//transições do Q2
        matriz[get_string_ref(estados, "Q2")][get_char_ref(alfabeto, '0')] = get_string_ref(estados, "Q3");
        matriz[get_string_ref(estados, "Q2")][get_char_ref(alfabeto, '1')] = get_string_ref(estados, "Q3");
        matriz[get_string_ref(estados, "Q2")][get_char_ref(alfabeto, '2')] = get_string_ref(estados, "Q3");
        matriz[get_string_ref(estados, "Q2")][get_char_ref(alfabeto, '3')] = get_string_ref(estados, "Q3");
        matriz[get_string_ref(estados, "Q2")][get_char_ref(alfabeto, '4')] = get_string_ref(estados, "Q3");
        matriz[get_string_ref(estados, "Q2")][get_char_ref(alfabeto, '5')] = get_string_ref(estados, "Q3");
        matriz[get_string_ref(estados, "Q2")][get_char_ref(alfabeto, '6')] = get_string_ref(estados, "Q3");
        matriz[get_string_ref(estados, "Q2")][get_char_ref(alfabeto, '7')] = get_string_ref(estados, "Q3");
        matriz[get_string_ref(estados, "Q2")][get_char_ref(alfabeto, '8')] = get_string_ref(estados, "Q3");
        matriz[get_string_ref(estados, "Q2")][get_char_ref(alfabeto, '9')] = get_string_ref(estados, "Q3");
        matriz[get_string_ref(estados, "Q2")][get_char_ref(alfabeto, '.')] = get_string_ref(estados, "Q7");
//transições do Q3
        matriz[get_string_ref(estados, "Q3")][get_char_ref(alfabeto, '0')] = get_string_ref(estados, "Q1");
        matriz[get_string_ref(estados, "Q3")][get_char_ref(alfabeto, '1')] = get_string_ref(estados, "Q1");
        matriz[get_string_ref(estados, "Q3")][get_char_ref(alfabeto, '2')] = get_string_ref(estados, "Q1");
        matriz[get_string_ref(estados, "Q3")][get_char_ref(alfabeto, '3')] = get_string_ref(estados, "Q1");
        matriz[get_string_ref(estados, "Q3")][get_char_ref(alfabeto, '4')] = get_string_ref(estados, "Q1");
        matriz[get_string_ref(estados, "Q3")][get_char_ref(alfabeto, '5')] = get_string_ref(estados, "Q1");
        matriz[get_string_ref(estados, "Q3")][get_char_ref(alfabeto, '6')] = get_string_ref(estados, "Q1");
        matriz[get_string_ref(estados, "Q3")][get_char_ref(alfabeto, '7')] = get_string_ref(estados, "Q1");
        matriz[get_string_ref(estados, "Q3")][get_char_ref(alfabeto, '8')] = get_string_ref(estados, "Q1");
        matriz[get_string_ref(estados, "Q3")][get_char_ref(alfabeto, '9')] = get_string_ref(estados, "Q1");
        matriz[get_string_ref(estados, "Q3")][get_char_ref(alfabeto, '.')] = get_string_ref(estados, "Q7");
//transições do Q4
        matriz[get_string_ref(estados, "Q4")][get_char_ref(alfabeto, '0')] = get_string_ref(estados, "Q3");
        matriz[get_string_ref(estados, "Q4")][get_char_ref(alfabeto, '1')] = get_string_ref(estados, "Q3");
        matriz[get_string_ref(estados, "Q4")][get_char_ref(alfabeto, '2')] = get_string_ref(estados, "Q3");
        matriz[get_string_ref(estados, "Q4")][get_char_ref(alfabeto, '3')] = get_string_ref(estados, "Q3");
        matriz[get_string_ref(estados, "Q4")][get_char_ref(alfabeto, '4')] = get_string_ref(estados, "Q3");
        matriz[get_string_ref(estados, "Q4")][get_char_ref(alfabeto, '5')] = get_string_ref(estados, "Q5");
        matriz[get_string_ref(estados, "Q4")][get_char_ref(alfabeto, '6')] = get_string_ref(estados, "Q6");
        matriz[get_string_ref(estados, "Q4")][get_char_ref(alfabeto, '7')] = get_string_ref(estados, "Q6");
        matriz[get_string_ref(estados, "Q4")][get_char_ref(alfabeto, '8')] = get_string_ref(estados, "Q6");
        matriz[get_string_ref(estados, "Q4")][get_char_ref(alfabeto, '9')] = get_string_ref(estados, "Q6");
        matriz[get_string_ref(estados, "Q4")][get_char_ref(alfabeto, '.')] = get_string_ref(estados, "Q7");
//transições do Q5
        matriz[get_string_ref(estados, "Q5")][get_char_ref(alfabeto, '0')] = get_string_ref(estados, "Q1");
        matriz[get_string_ref(estados, "Q5")][get_char_ref(alfabeto, '1')] = get_string_ref(estados, "Q1");
        matriz[get_string_ref(estados, "Q5")][get_char_ref(alfabeto, '2')] = get_string_ref(estados, "Q1");
        matriz[get_string_ref(estados, "Q5")][get_char_ref(alfabeto, '3')] = get_string_ref(estados, "Q1");
        matriz[get_string_ref(estados, "Q5")][get_char_ref(alfabeto, '4')] = get_string_ref(estados, "Q1");
        matriz[get_string_ref(estados, "Q5")][get_char_ref(alfabeto, '5')] = get_string_ref(estados, "Q1");
        matriz[get_string_ref(estados, "Q5")][get_char_ref(alfabeto, '6')] = -1;
        matriz[get_string_ref(estados, "Q5")][get_char_ref(alfabeto, '7')] = -1;
        matriz[get_string_ref(estados, "Q5")][get_char_ref(alfabeto, '8')] = -1;
        matriz[get_string_ref(estados, "Q5")][get_char_ref(alfabeto, '9')] = -1;
        matriz[get_string_ref(estados, "Q5")][get_char_ref(alfabeto, '.')] = get_string_ref(estados, "Q7");
//transições do Q6
        matriz[get_string_ref(estados, "Q6")][get_char_ref(alfabeto, '0')] = -1;
        matriz[get_string_ref(estados, "Q6")][get_char_ref(alfabeto, '1')] = -1;
        matriz[get_string_ref(estados, "Q6")][get_char_ref(alfabeto, '2')] = -1;
        matriz[get_string_ref(estados, "Q6")][get_char_ref(alfabeto, '3')] = -1;
        matriz[get_string_ref(estados, "Q6")][get_char_ref(alfabeto, '4')] = -1;
        matriz[get_string_ref(estados, "Q6")][get_char_ref(alfabeto, '5')] = -1;
        matriz[get_string_ref(estados, "Q6")][get_char_ref(alfabeto, '6')] = -1;
        matriz[get_string_ref(estados, "Q6")][get_char_ref(alfabeto, '7')] = -1;
        matriz[get_string_ref(estados, "Q6")][get_char_ref(alfabeto, '8')] = -1;
        matriz[get_string_ref(estados, "Q6")][get_char_ref(alfabeto, '9')] = -1;
        matriz[get_string_ref(estados, "Q6")][get_char_ref(alfabeto, '.')] = get_string_ref(estados, "Q7");
//transições do Q7
        matriz[get_string_ref(estados, "Q7")][get_char_ref(alfabeto, '0')] = get_string_ref(estados, "Q8");
        matriz[get_string_ref(estados, "Q7")][get_char_ref(alfabeto, '1')] = get_string_ref(estados, "Q9");
        matriz[get_string_ref(estados, "Q7")][get_char_ref(alfabeto, '2')] = get_string_ref(estados, "Q11");
        matriz[get_string_ref(estados, "Q7")][get_char_ref(alfabeto, '3')] = get_string_ref(estados, "Q10");
        matriz[get_string_ref(estados, "Q7")][get_char_ref(alfabeto, '4')] = get_string_ref(estados, "Q10");
        matriz[get_string_ref(estados, "Q7")][get_char_ref(alfabeto, '5')] = get_string_ref(estados, "Q10");
        matriz[get_string_ref(estados, "Q7")][get_char_ref(alfabeto, '6')] = get_string_ref(estados, "Q10");
        matriz[get_string_ref(estados, "Q7")][get_char_ref(alfabeto, '7')] = get_string_ref(estados, "Q10");
        matriz[get_string_ref(estados, "Q7")][get_char_ref(alfabeto, '8')] = get_string_ref(estados, "Q10");
        matriz[get_string_ref(estados, "Q7")][get_char_ref(alfabeto, '9')] = get_string_ref(estados, "Q10");
        matriz[get_string_ref(estados, "Q7")][get_char_ref(alfabeto, '.')] = -1;
//transições do Q8
        matriz[get_string_ref(estados, "Q8")][get_char_ref(alfabeto, '0')] = -1;
        matriz[get_string_ref(estados, "Q8")][get_char_ref(alfabeto, '1')] = -1;
        matriz[get_string_ref(estados, "Q8")][get_char_ref(alfabeto, '2')] = -1;
        matriz[get_string_ref(estados, "Q8")][get_char_ref(alfabeto, '3')] = -1;
        matriz[get_string_ref(estados, "Q8")][get_char_ref(alfabeto, '4')] = -1;
        matriz[get_string_ref(estados, "Q8")][get_char_ref(alfabeto, '5')] = -1;
        matriz[get_string_ref(estados, "Q8")][get_char_ref(alfabeto, '6')] = -1;
        matriz[get_string_ref(estados, "Q8")][get_char_ref(alfabeto, '7')] = -1;
        matriz[get_string_ref(estados, "Q8")][get_char_ref(alfabeto, '8')] = -1;
        matriz[get_string_ref(estados, "Q8")][get_char_ref(alfabeto, '9')] = -1;
        matriz[get_string_ref(estados, "Q8")][get_char_ref(alfabeto, '.')] = get_string_ref(estados, "Q14");
//transições do Q9
        matriz[get_string_ref(estados, "Q9")][get_char_ref(alfabeto, '0')] = get_string_ref(estados, "Q10");
        matriz[get_string_ref(estados, "Q9")][get_char_ref(alfabeto, '1')] = get_string_ref(estados, "Q10");
        matriz[get_string_ref(estados, "Q9")][get_char_ref(alfabeto, '2')] = get_string_ref(estados, "Q10");
        matriz[get_string_ref(estados, "Q9")][get_char_ref(alfabeto, '3')] = get_string_ref(estados, "Q10");
        matriz[get_string_ref(estados, "Q9")][get_char_ref(alfabeto, '4')] = get_string_ref(estados, "Q10");
        matriz[get_string_ref(estados, "Q9")][get_char_ref(alfabeto, '5')] = get_string_ref(estados, "Q10");
        matriz[get_string_ref(estados, "Q9")][get_char_ref(alfabeto, '6')] = get_string_ref(estados, "Q10");
        matriz[get_string_ref(estados, "Q9")][get_char_ref(alfabeto, '7')] = get_string_ref(estados, "Q10");
        matriz[get_string_ref(estados, "Q9")][get_char_ref(alfabeto, '8')] = get_string_ref(estados, "Q10");
        matriz[get_string_ref(estados, "Q9")][get_char_ref(alfabeto, '9')] = get_string_ref(estados, "Q10");
        matriz[get_string_ref(estados, "Q9")][get_char_ref(alfabeto, '.')] = get_string_ref(estados, "Q14");
//transições do Q10
        matriz[get_string_ref(estados, "Q10")][get_char_ref(alfabeto, '0')] = get_string_ref(estados, "Q8");
        matriz[get_string_ref(estados, "Q10")][get_char_ref(alfabeto, '1')] = get_string_ref(estados, "Q8");
        matriz[get_string_ref(estados, "Q10")][get_char_ref(alfabeto, '2')] = get_string_ref(estados, "Q8");
        matriz[get_string_ref(estados, "Q10")][get_char_ref(alfabeto, '3')] = get_string_ref(estados, "Q8");
        matriz[get_string_ref(estados, "Q10")][get_char_ref(alfabeto, '4')] = get_string_ref(estados, "Q8");
        matriz[get_string_ref(estados, "Q10")][get_char_ref(alfabeto, '5')] = get_string_ref(estados, "Q8");
        matriz[get_string_ref(estados, "Q10")][get_char_ref(alfabeto, '6')] = get_string_ref(estados, "Q8");
        matriz[get_string_ref(estados, "Q10")][get_char_ref(alfabeto, '7')] = get_string_ref(estados, "Q8");
        matriz[get_string_ref(estados, "Q10")][get_char_ref(alfabeto, '8')] = get_string_ref(estados, "Q8");
        matriz[get_string_ref(estados, "Q10")][get_char_ref(alfabeto, '9')] = get_string_ref(estados, "Q8");
        matriz[get_string_ref(estados, "Q10")][get_char_ref(alfabeto, '.')] = get_string_ref(estados, "Q14");
//transições do Q11
        matriz[get_string_ref(estados, "Q11")][get_char_ref(alfabeto, '0')] = get_string_ref(estados, "Q10");
        matriz[get_string_ref(estados, "Q11")][get_char_ref(alfabeto, '1')] = get_string_ref(estados, "Q10");
        matriz[get_string_ref(estados, "Q11")][get_char_ref(alfabeto, '2')] = get_string_ref(estados, "Q10");
        matriz[get_string_ref(estados, "Q11")][get_char_ref(alfabeto, '3')] = get_string_ref(estados, "Q10");
        matriz[get_string_ref(estados, "Q11")][get_char_ref(alfabeto, '4')] = get_string_ref(estados, "Q10");
        matriz[get_string_ref(estados, "Q11")][get_char_ref(alfabeto, '5')] = get_string_ref(estados, "Q12");
        matriz[get_string_ref(estados, "Q11")][get_char_ref(alfabeto, '6')] = get_string_ref(estados, "Q13");
        matriz[get_string_ref(estados, "Q11")][get_char_ref(alfabeto, '7')] = get_string_ref(estados, "Q13");
        matriz[get_string_ref(estados, "Q11")][get_char_ref(alfabeto, '8')] = get_string_ref(estados, "Q13");
        matriz[get_string_ref(estados, "Q11")][get_char_ref(alfabeto, '9')] = get_string_ref(estados, "Q13");
        matriz[get_string_ref(estados, "Q11")][get_char_ref(alfabeto, '.')] = get_string_ref(estados, "Q14");
//transições do Q12
        matriz[get_string_ref(estados, "Q12")][get_char_ref(alfabeto, '0')] = get_string_ref(estados, "Q8");
        matriz[get_string_ref(estados, "Q12")][get_char_ref(alfabeto, '1')] = get_string_ref(estados, "Q8");
        matriz[get_string_ref(estados, "Q12")][get_char_ref(alfabeto, '2')] = get_string_ref(estados, "Q8");
        matriz[get_string_ref(estados, "Q12")][get_char_ref(alfabeto, '3')] = get_string_ref(estados, "Q8");
        matriz[get_string_ref(estados, "Q12")][get_char_ref(alfabeto, '4')] = get_string_ref(estados, "Q8");
        matriz[get_string_ref(estados, "Q12")][get_char_ref(alfabeto, '5')] = get_string_ref(estados, "Q8");
        matriz[get_string_ref(estados, "Q12")][get_char_ref(alfabeto, '6')] = -1;
        matriz[get_string_ref(estados, "Q12")][get_char_ref(alfabeto, '7')] = -1;
        matriz[get_string_ref(estados, "Q12")][get_char_ref(alfabeto, '8')] = -1;
        matriz[get_string_ref(estados, "Q12")][get_char_ref(alfabeto, '9')] = -1;
        matriz[get_string_ref(estados, "Q12")][get_char_ref(alfabeto, '.')] = get_string_ref(estados, "Q14");
//transições do Q13
        matriz[get_string_ref(estados, "Q13")][get_char_ref(alfabeto, '0')] = -1;
        matriz[get_string_ref(estados, "Q13")][get_char_ref(alfabeto, '1')] = -1;
        matriz[get_string_ref(estados, "Q13")][get_char_ref(alfabeto, '2')] = -1;
        matriz[get_string_ref(estados, "Q13")][get_char_ref(alfabeto, '3')] = -1;
        matriz[get_string_ref(estados, "Q13")][get_char_ref(alfabeto, '4')] = -1;
        matriz[get_string_ref(estados, "Q13")][get_char_ref(alfabeto, '5')] = -1;
        matriz[get_string_ref(estados, "Q13")][get_char_ref(alfabeto, '6')] = -1;
        matriz[get_string_ref(estados, "Q13")][get_char_ref(alfabeto, '7')] = -1;
        matriz[get_string_ref(estados, "Q13")][get_char_ref(alfabeto, '8')] = -1;
        matriz[get_string_ref(estados, "Q13")][get_char_ref(alfabeto, '9')] = -1;
        matriz[get_string_ref(estados, "Q13")][get_char_ref(alfabeto, '.')] = get_string_ref(estados, "Q14");
//transições do Q14
        matriz[get_string_ref(estados, "Q14")][get_char_ref(alfabeto, '0')] = get_string_ref(estados, "Q15");
        matriz[get_string_ref(estados, "Q14")][get_char_ref(alfabeto, '1')] = get_string_ref(estados, "Q16");
        matriz[get_string_ref(estados, "Q14")][get_char_ref(alfabeto, '2')] = get_string_ref(estados, "Q18");
        matriz[get_string_ref(estados, "Q14")][get_char_ref(alfabeto, '3')] = get_string_ref(estados, "Q17");
        matriz[get_string_ref(estados, "Q14")][get_char_ref(alfabeto, '4')] = get_string_ref(estados, "Q17");
        matriz[get_string_ref(estados, "Q14")][get_char_ref(alfabeto, '5')] = get_string_ref(estados, "Q17");
        matriz[get_string_ref(estados, "Q14")][get_char_ref(alfabeto, '6')] = get_string_ref(estados, "Q17");
        matriz[get_string_ref(estados, "Q14")][get_char_ref(alfabeto, '7')] = get_string_ref(estados, "Q17");
        matriz[get_string_ref(estados, "Q14")][get_char_ref(alfabeto, '8')] = get_string_ref(estados, "Q17");
        matriz[get_string_ref(estados, "Q14")][get_char_ref(alfabeto, '9')] = get_string_ref(estados, "Q17");
        matriz[get_string_ref(estados, "Q14")][get_char_ref(alfabeto, '.')] = -1;
//transições do Q15
        matriz[get_string_ref(estados, "Q15")][get_char_ref(alfabeto, '0')] = -1;
        matriz[get_string_ref(estados, "Q15")][get_char_ref(alfabeto, '1')] = -1;
        matriz[get_string_ref(estados, "Q15")][get_char_ref(alfabeto, '2')] = -1;
        matriz[get_string_ref(estados, "Q15")][get_char_ref(alfabeto, '3')] = -1;
        matriz[get_string_ref(estados, "Q15")][get_char_ref(alfabeto, '4')] = -1;
        matriz[get_string_ref(estados, "Q15")][get_char_ref(alfabeto, '5')] = -1;
        matriz[get_string_ref(estados, "Q15")][get_char_ref(alfabeto, '6')] = -1;
        matriz[get_string_ref(estados, "Q15")][get_char_ref(alfabeto, '7')] = -1;
        matriz[get_string_ref(estados, "Q15")][get_char_ref(alfabeto, '8')] = -1;
        matriz[get_string_ref(estados, "Q15")][get_char_ref(alfabeto, '9')] = -1;
        matriz[get_string_ref(estados, "Q15")][get_char_ref(alfabeto, '.')] = get_string_ref(estados, "Q21");
//transições do Q16
        matriz[get_string_ref(estados, "Q16")][get_char_ref(alfabeto, '0')] = get_string_ref(estados, "Q17");
        matriz[get_string_ref(estados, "Q16")][get_char_ref(alfabeto, '1')] = get_string_ref(estados, "Q17");
        matriz[get_string_ref(estados, "Q16")][get_char_ref(alfabeto, '2')] = get_string_ref(estados, "Q17");
        matriz[get_string_ref(estados, "Q16")][get_char_ref(alfabeto, '3')] = get_string_ref(estados, "Q17");
        matriz[get_string_ref(estados, "Q16")][get_char_ref(alfabeto, '4')] = get_string_ref(estados, "Q17");
        matriz[get_string_ref(estados, "Q16")][get_char_ref(alfabeto, '5')] = get_string_ref(estados, "Q17");
        matriz[get_string_ref(estados, "Q16")][get_char_ref(alfabeto, '6')] = get_string_ref(estados, "Q17");
        matriz[get_string_ref(estados, "Q16")][get_char_ref(alfabeto, '7')] = get_string_ref(estados, "Q17");
        matriz[get_string_ref(estados, "Q16")][get_char_ref(alfabeto, '8')] = get_string_ref(estados, "Q17");
        matriz[get_string_ref(estados, "Q16")][get_char_ref(alfabeto, '9')] = get_string_ref(estados, "Q17");
        matriz[get_string_ref(estados, "Q16")][get_char_ref(alfabeto, '.')] = get_string_ref(estados, "Q21");
//transições do Q17
        matriz[get_string_ref(estados, "Q17")][get_char_ref(alfabeto, '0')] = get_string_ref(estados, "Q15");
        matriz[get_string_ref(estados, "Q17")][get_char_ref(alfabeto, '1')] = get_string_ref(estados, "Q15");
        matriz[get_string_ref(estados, "Q17")][get_char_ref(alfabeto, '2')] = get_string_ref(estados, "Q15");
        matriz[get_string_ref(estados, "Q17")][get_char_ref(alfabeto, '3')] = get_string_ref(estados, "Q15");
        matriz[get_string_ref(estados, "Q17")][get_char_ref(alfabeto, '4')] = get_string_ref(estados, "Q15");
        matriz[get_string_ref(estados, "Q17")][get_char_ref(alfabeto, '5')] = get_string_ref(estados, "Q15");
        matriz[get_string_ref(estados, "Q17")][get_char_ref(alfabeto, '6')] = get_string_ref(estados, "Q15");
        matriz[get_string_ref(estados, "Q17")][get_char_ref(alfabeto, '7')] = get_string_ref(estados, "Q15");
        matriz[get_string_ref(estados, "Q17")][get_char_ref(alfabeto, '8')] = get_string_ref(estados, "Q15");
        matriz[get_string_ref(estados, "Q17")][get_char_ref(alfabeto, '9')] = get_string_ref(estados, "Q15");
        matriz[get_string_ref(estados, "Q17")][get_char_ref(alfabeto, '.')] = get_string_ref(estados, "Q21");
//transições do Q18
        matriz[get_string_ref(estados, "Q18")][get_char_ref(alfabeto, '0')] = get_string_ref(estados, "Q17");
        matriz[get_string_ref(estados, "Q18")][get_char_ref(alfabeto, '1')] = get_string_ref(estados, "Q17");
        matriz[get_string_ref(estados, "Q18")][get_char_ref(alfabeto, '2')] = get_string_ref(estados, "Q17");
        matriz[get_string_ref(estados, "Q18")][get_char_ref(alfabeto, '3')] = get_string_ref(estados, "Q17");
        matriz[get_string_ref(estados, "Q18")][get_char_ref(alfabeto, '4')] = get_string_ref(estados, "Q17");
        matriz[get_string_ref(estados, "Q18")][get_char_ref(alfabeto, '5')] = get_string_ref(estados, "Q19");
        matriz[get_string_ref(estados, "Q18")][get_char_ref(alfabeto, '6')] = get_string_ref(estados, "Q20");
        matriz[get_string_ref(estados, "Q18")][get_char_ref(alfabeto, '7')] = get_string_ref(estados, "Q20");
        matriz[get_string_ref(estados, "Q18")][get_char_ref(alfabeto, '8')] = get_string_ref(estados, "Q20");
        matriz[get_string_ref(estados, "Q18")][get_char_ref(alfabeto, '9')] = get_string_ref(estados, "Q20");
        matriz[get_string_ref(estados, "Q18")][get_char_ref(alfabeto, '.')] = get_string_ref(estados, "Q21");
//transições do Q19
        matriz[get_string_ref(estados, "Q19")][get_char_ref(alfabeto, '0')] = get_string_ref(estados, "Q15");
        matriz[get_string_ref(estados, "Q19")][get_char_ref(alfabeto, '1')] = get_string_ref(estados, "Q15");
        matriz[get_string_ref(estados, "Q19")][get_char_ref(alfabeto, '2')] = get_string_ref(estados, "Q15");
        matriz[get_string_ref(estados, "Q19")][get_char_ref(alfabeto, '3')] = get_string_ref(estados, "Q15");
        matriz[get_string_ref(estados, "Q19")][get_char_ref(alfabeto, '4')] = get_string_ref(estados, "Q15");
        matriz[get_string_ref(estados, "Q19")][get_char_ref(alfabeto, '5')] = get_string_ref(estados, "Q15");
        matriz[get_string_ref(estados, "Q19")][get_char_ref(alfabeto, '6')] = -1;
        matriz[get_string_ref(estados, "Q19")][get_char_ref(alfabeto, '7')] = -1;
        matriz[get_string_ref(estados, "Q19")][get_char_ref(alfabeto, '8')] = -1;
        matriz[get_string_ref(estados, "Q19")][get_char_ref(alfabeto, '9')] = -1;
        matriz[get_string_ref(estados, "Q19")][get_char_ref(alfabeto, '.')] = get_string_ref(estados, "Q21");
//transições do Q20
        matriz[get_string_ref(estados, "Q20")][get_char_ref(alfabeto, '0')] = -1;
        matriz[get_string_ref(estados, "Q20")][get_char_ref(alfabeto, '1')] = -1;
        matriz[get_string_ref(estados, "Q20")][get_char_ref(alfabeto, '2')] = -1;
        matriz[get_string_ref(estados, "Q20")][get_char_ref(alfabeto, '3')] = -1;
        matriz[get_string_ref(estados, "Q20")][get_char_ref(alfabeto, '4')] = -1;
        matriz[get_string_ref(estados, "Q20")][get_char_ref(alfabeto, '5')] = -1;
        matriz[get_string_ref(estados, "Q20")][get_char_ref(alfabeto, '6')] = -1;
        matriz[get_string_ref(estados, "Q20")][get_char_ref(alfabeto, '7')] = -1;
        matriz[get_string_ref(estados, "Q20")][get_char_ref(alfabeto, '8')] = -1;
        matriz[get_string_ref(estados, "Q20")][get_char_ref(alfabeto, '9')] = -1;
        matriz[get_string_ref(estados, "Q20")][get_char_ref(alfabeto, '.')] = get_string_ref(estados, "Q21");
//transições do Q21
        matriz[get_string_ref(estados, "Q21")][get_char_ref(alfabeto, '0')] = get_string_ref(estados, "Q22");
        matriz[get_string_ref(estados, "Q21")][get_char_ref(alfabeto, '1')] = get_string_ref(estados, "Q23");
        matriz[get_string_ref(estados, "Q21")][get_char_ref(alfabeto, '2')] = get_string_ref(estados, "Q25");
        matriz[get_string_ref(estados, "Q21")][get_char_ref(alfabeto, '3')] = get_string_ref(estados, "Q24");
        matriz[get_string_ref(estados, "Q21")][get_char_ref(alfabeto, '4')] = get_string_ref(estados, "Q24");
        matriz[get_string_ref(estados, "Q21")][get_char_ref(alfabeto, '5')] = get_string_ref(estados, "Q24");
        matriz[get_string_ref(estados, "Q21")][get_char_ref(alfabeto, '6')] = get_string_ref(estados, "Q24");
        matriz[get_string_ref(estados, "Q21")][get_char_ref(alfabeto, '7')] = get_string_ref(estados, "Q24");
        matriz[get_string_ref(estados, "Q21")][get_char_ref(alfabeto, '8')] = get_string_ref(estados, "Q24");
        matriz[get_string_ref(estados, "Q21")][get_char_ref(alfabeto, '9')] = get_string_ref(estados, "Q24");
        matriz[get_string_ref(estados, "Q21")][get_char_ref(alfabeto, '.')] = -1;
//transições do Q22
        matriz[get_string_ref(estados, "Q22")][get_char_ref(alfabeto, '0')] = -1;
        matriz[get_string_ref(estados, "Q22")][get_char_ref(alfabeto, '1')] = -1;
        matriz[get_string_ref(estados, "Q22")][get_char_ref(alfabeto, '2')] = -1;
        matriz[get_string_ref(estados, "Q22")][get_char_ref(alfabeto, '3')] = -1;
        matriz[get_string_ref(estados, "Q22")][get_char_ref(alfabeto, '4')] = -1;
        matriz[get_string_ref(estados, "Q22")][get_char_ref(alfabeto, '5')] = -1;
        matriz[get_string_ref(estados, "Q22")][get_char_ref(alfabeto, '6')] = -1;
        matriz[get_string_ref(estados, "Q22")][get_char_ref(alfabeto, '7')] = -1;
        matriz[get_string_ref(estados, "Q22")][get_char_ref(alfabeto, '8')] = -1;
        matriz[get_string_ref(estados, "Q22")][get_char_ref(alfabeto, '9')] = -1;
        matriz[get_string_ref(estados, "Q22")][get_char_ref(alfabeto, '.')] = -1;
//transições do Q23
        matriz[get_string_ref(estados, "Q23")][get_char_ref(alfabeto, '0')] = get_string_ref(estados, "Q24");
        matriz[get_string_ref(estados, "Q23")][get_char_ref(alfabeto, '1')] = get_string_ref(estados, "Q24");
        matriz[get_string_ref(estados, "Q23")][get_char_ref(alfabeto, '2')] = get_string_ref(estados, "Q24");
        matriz[get_string_ref(estados, "Q23")][get_char_ref(alfabeto, '3')] = get_string_ref(estados, "Q24");
        matriz[get_string_ref(estados, "Q23")][get_char_ref(alfabeto, '4')] = get_string_ref(estados, "Q24");
        matriz[get_string_ref(estados, "Q23")][get_char_ref(alfabeto, '5')] = get_string_ref(estados, "Q24");
        matriz[get_string_ref(estados, "Q23")][get_char_ref(alfabeto, '6')] = get_string_ref(estados, "Q24");
        matriz[get_string_ref(estados, "Q23")][get_char_ref(alfabeto, '7')] = get_string_ref(estados, "Q24");
        matriz[get_string_ref(estados, "Q23")][get_char_ref(alfabeto, '8')] = get_string_ref(estados, "Q24");
        matriz[get_string_ref(estados, "Q23")][get_char_ref(alfabeto, '9')] = get_string_ref(estados, "Q24");
        matriz[get_string_ref(estados, "Q23")][get_char_ref(alfabeto, '.')] = -1;
//transições do Q24
        matriz[get_string_ref(estados, "Q24")][get_char_ref(alfabeto, '0')] = get_string_ref(estados, "Q22");
        matriz[get_string_ref(estados, "Q24")][get_char_ref(alfabeto, '1')] = get_string_ref(estados, "Q22");
        matriz[get_string_ref(estados, "Q24")][get_char_ref(alfabeto, '2')] = get_string_ref(estados, "Q22");
        matriz[get_string_ref(estados, "Q24")][get_char_ref(alfabeto, '3')] = get_string_ref(estados, "Q22");
        matriz[get_string_ref(estados, "Q24")][get_char_ref(alfabeto, '4')] = get_string_ref(estados, "Q22");
        matriz[get_string_ref(estados, "Q24")][get_char_ref(alfabeto, '5')] = get_string_ref(estados, "Q22");
        matriz[get_string_ref(estados, "Q24")][get_char_ref(alfabeto, '6')] = get_string_ref(estados, "Q22");
        matriz[get_string_ref(estados, "Q24")][get_char_ref(alfabeto, '7')] = get_string_ref(estados, "Q22");
        matriz[get_string_ref(estados, "Q24")][get_char_ref(alfabeto, '8')] = get_string_ref(estados, "Q22");
        matriz[get_string_ref(estados, "Q24")][get_char_ref(alfabeto, '9')] = get_string_ref(estados, "Q22");
        matriz[get_string_ref(estados, "Q24")][get_char_ref(alfabeto, '.')] = -1;
//transições do Q25
        matriz[get_string_ref(estados, "Q25")][get_char_ref(alfabeto, '0')] = get_string_ref(estados, "Q24");
        matriz[get_string_ref(estados, "Q25")][get_char_ref(alfabeto, '1')] = get_string_ref(estados, "Q24");
        matriz[get_string_ref(estados, "Q25")][get_char_ref(alfabeto, '2')] = get_string_ref(estados, "Q24");
        matriz[get_string_ref(estados, "Q25")][get_char_ref(alfabeto, '3')] = get_string_ref(estados, "Q24");
        matriz[get_string_ref(estados, "Q25")][get_char_ref(alfabeto, '4')] = get_string_ref(estados, "Q24");
        matriz[get_string_ref(estados, "Q25")][get_char_ref(alfabeto, '5')] = get_string_ref(estados, "Q26");
        matriz[get_string_ref(estados, "Q25")][get_char_ref(alfabeto, '6')] = get_string_ref(estados, "Q27");
        matriz[get_string_ref(estados, "Q25")][get_char_ref(alfabeto, '7')] = get_string_ref(estados, "Q27");
        matriz[get_string_ref(estados, "Q25")][get_char_ref(alfabeto, '8')] = get_string_ref(estados, "Q27");
        matriz[get_string_ref(estados, "Q25")][get_char_ref(alfabeto, '9')] = get_string_ref(estados, "Q27");
        matriz[get_string_ref(estados, "Q25")][get_char_ref(alfabeto, '.')] = -1;
//transições do Q26
        matriz[get_string_ref(estados, "Q26")][get_char_ref(alfabeto, '0')] = get_string_ref(estados, "Q22");
        matriz[get_string_ref(estados, "Q26")][get_char_ref(alfabeto, '1')] = get_string_ref(estados, "Q22");
        matriz[get_string_ref(estados, "Q26")][get_char_ref(alfabeto, '2')] = get_string_ref(estados, "Q22");
        matriz[get_string_ref(estados, "Q26")][get_char_ref(alfabeto, '3')] = get_string_ref(estados, "Q22");
        matriz[get_string_ref(estados, "Q26")][get_char_ref(alfabeto, '4')] = get_string_ref(estados, "Q22");
        matriz[get_string_ref(estados, "Q26")][get_char_ref(alfabeto, '5')] = get_string_ref(estados, "Q22");
        matriz[get_string_ref(estados, "Q26")][get_char_ref(alfabeto, '6')] = -1;
        matriz[get_string_ref(estados, "Q26")][get_char_ref(alfabeto, '7')] = -1;
        matriz[get_string_ref(estados, "Q26")][get_char_ref(alfabeto, '8')] = -1;
        matriz[get_string_ref(estados, "Q26")][get_char_ref(alfabeto, '9')] = -1;
        matriz[get_string_ref(estados, "Q26")][get_char_ref(alfabeto, '.')] = -1;
//transições do Q27
        matriz[get_string_ref(estados, "Q27")][get_char_ref(alfabeto, '0')] = -1;
        matriz[get_string_ref(estados, "Q27")][get_char_ref(alfabeto, '1')] = -1;
        matriz[get_string_ref(estados, "Q27")][get_char_ref(alfabeto, '2')] = -1;
        matriz[get_string_ref(estados, "Q27")][get_char_ref(alfabeto, '3')] = -1;
        matriz[get_string_ref(estados, "Q27")][get_char_ref(alfabeto, '4')] = -1;
        matriz[get_string_ref(estados, "Q27")][get_char_ref(alfabeto, '5')] = -1;
        matriz[get_string_ref(estados, "Q27")][get_char_ref(alfabeto, '6')] = -1;
        matriz[get_string_ref(estados, "Q27")][get_char_ref(alfabeto, '7')] = -1;
        matriz[get_string_ref(estados, "Q27")][get_char_ref(alfabeto, '8')] = -1;
        matriz[get_string_ref(estados, "Q27")][get_char_ref(alfabeto, '9')] = -1;
        matriz[get_string_ref(estados, "Q27")][get_char_ref(alfabeto, '.')] = -1;


        int estado = get_string_ref (estados, estado_inicial);
        int estado_anterior = -1;
        ArrayList<String> palavras_reconhecidas = new ArrayList();

        String palavra = "";

        for (int j = 0; j < 3; j++) {
            System.out.println("=-=-=-=-=-");
            System.out.println("Site: " + crw.getListaRecursos().get(j));

            String codigoHTML = listaCodigos.get(j);

            //varre o código-fonte de um código
            for (int i=0; i<codigoHTML.length(); i++){

                estado_anterior = estado;
                estado = proximo_estado(alfabeto, matriz, estado, codigoHTML.charAt(i));
                //se o não há transição
                if (estado == -1){
                    //pega estado inicial
                    estado = get_string_ref(estados, estado_inicial);
                    // se o estado anterior foi um estado final
                    if (get_string_ref(estados_finais, estados[estado_anterior]) != -1){
                        //se a palavra não é vazia adiciona palavra reconhecida
                        if ( ! palavra.equals("")){
                            palavras_reconhecidas.add(palavra);
                        }
                        // se ao analisar este caracter não houve transição
                        // teste-o novamente, considerando que o estado seja inicial
                        i--;
                    }
                    //zera palavra
                    palavra = "";

                }else{
                    //se houver transição válida, adiciona caracter a palavra
                    palavra += codigoHTML.charAt(i);
                }
            }


            //foreach no Java para exibir todas as palavras reconhecidas
            for (String p: palavras_reconhecidas){
                System.out.println (p);
            }
        }



    }



}
