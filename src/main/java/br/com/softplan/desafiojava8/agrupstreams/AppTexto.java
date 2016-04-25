package br.com.softplan.desafiojava8.agrupstreams;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AppTexto
{
    public static void main( String[] args )
    {
        // conte quantas ocorrências existem de cada uma das palavras abaixo,
        // da 'Revolução dos Bichos'. Ordene a lista de forma decrescente,
        // excluindo da contagem as palavras que só aparecem uma vez.
        String paragrafo =
                "Doze vozes gritavam, cheias de ódio, e eram todos iguais. Não havia dúvida, " +
                "agora, quanto ao que sucedera à fisionomia dos porcos. As criaturas de fora olhavam " +
                "de um porco para um homem, de um homem para um porco e de um porco para um homem outra vez; " +
                "mas já se tornara impossível distinguir, quem era homem, quem era porco.";

        Stream.of(paragrafo.split(" "))
            .map(s -> s.replaceAll("[,;\\.]", ""))
            .map(s -> s.toUpperCase())
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet()
            .stream()
            .filter( e -> e.getValue() > 1)
            .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
            .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));


    }
}
