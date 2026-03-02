import java.util.Scanner;
public class Main {
    //metodo a observar
    public static int calcularFinal(int precioBase,int descuento){
        return precioBase-(precioBase*descuento/100);
    }
    /* 8 casos de prueba
    entrada(precioBase,descuento)   (resutado esperado)             (oraculo)                                   (tipo)
    1.        100,0     -10             exepcion o error            devuelve 110->incorrecto                     negativo
    2.        200        150            exepcion o error            devuelve -100->precio negativo               negativo
    3.        -50         0             exepcion o error             devuelve -50->precio base invalido          negativo
    4.        1           1             1-(1x1/100)=1-0=1
    5.       999          99            9                            descuento casi total
    6.       50           25            37                           50-(50x25/100)=50-12=38 hay que tener cuidado con la division entera
    7.       100          50            50                           descuento del 50%
    8.       100          0             100                          sin descuento->precio sin cambio

    he cubierto casos de prueba de equivalencia negativa,normal.precio 0 valores pequeños y grandes para dectectar truncamiento por division entera
     */

    /*
    descuento negativo
    resultado = precioBase-(precioBasex(-10)/100) ->se suma el 10%->precio aumenta
    fallo el metodo acepta y devuelve precio mayor

    descuento>100(ejemplo 150)
    resultado=precioBase-(precioBasex150 /100)->precio negativo
    fallo precio negativo no tiene sentido comercial

    deberia permitirlo? no es un metodo "seguro" debe rechazar valores fuera de [0..100]

     */



    /*
    ejercicio3 mejora del metodo
     */
    public static int calcularPrecioFinal(int precioBase,int descuento){
        if (descuento <0 || descuento >100){
            throw new IllegalArgumentException("el decuento debe estar entre 0 y 100");
        }
        // evita overflow usando long
        return (int) (precioBase -(long) precioBase *descuento /100);
    }
    //es mejor validcion por que evita  (precioBase=1_000_000 y descuento=100 → sin long habría problema). y tiene un comportamiento predecible

    /*
    bloque 2-cazador de bugs
    ejercicio 4 y 3 entradas donde falla

    entrada                 resultado obtenido      resultado correcto          tipo de fallo
    1.int[]{}(vacios)            0                        exepcion              no maneja array vacio
    2.int[] {-5,-1,-10}          0                          -1                  inicializa en 0-> no funciona conn numeros negativos
    3.int[] {-7}                  0                          -7                 mismo problema anterior
    el bug es aumir que los datos siempre son positivos y el array nunca este vacio
     */

    //ejercicio 5-version corregida
    public static int maximo(int[] datos) {
        if (datos == null || datos.length == 0) {
            throw new IllegalArgumentException("El array no puede estar vacío o ser null");
        }
        int max = datos[0];               // empezamos con el primer elemento
        for (int i = 1; i < datos.length; i++) {
            if (datos[i] > max) {
                max = datos[i];
            }
        }
        return max;
    }

    /*
    bloque 3-diseña el oraculo
    ejercicio 6 – 3 propiedades que SIEMPRE deben cumplir el resultado de ordenar

misma longitu= resultado.length == datos.length
mismos elementos (misma multiset): el resultado contiene exactamente los mismos números con las mismas repeticiones.
está ordenado no decreciente para

ejercicio 7 – ¿Por qué es mejor usar oráculos por propiedades?
porque no sabemos el algoritmo (es caja negra).
si usamos valores concretos tendríamos que calcular manualmente el array ordenado para cada prueba → muy frágil.
con propiedades verificamos que “sea correcto” independientemente del input. Esto es la base del property-based testing (usado en bibliotecas como QuickCheck, JUnit-QuickCheck, etc.).
     */

    /*
    bloque 4-caminos y decisiones:metodo
    public static String clasificarEdad(int edad) {
    if (edad < 0) {
        return "ERROR";
    } else if (edad < 12) {
        return "NIÑO";
    } else if (edad < 18) {
        return "ADOLESCENTE";
    } else {
        return "ADULTO";
    }
}
    ejercico 8-numero minimo de tests
    4tests uno por cada rama del if-else
     */

    /*
    ejercicio 9 -los 4 test minimos
    test            edad            Resultado esperado
     1               -1              "error"
     2                8              "niño"
     3                15             "adolescente"
     4                 25            "adulto"

     valores min 0,11,12,17,18 valores limite

     */

    /*
    bloque 6-prioriza como un profesional

    ejercicio 10 orden de prioridad(mayor->menor)
    1.login= sin login no se puede hacer nada
    2pago con tarjeta=es el flujo que genera dinero fallo  aqui=perdida economica directa mas la reputacion
    3 mostrar catalogo=sin el catalogo el usuario no puede comprar
    4recuperar contraseña ->funcionalidad critica de usabilidad y retencion de usuarios
    5 cambiar avatar =cosmetico bajo impacto
     */

}