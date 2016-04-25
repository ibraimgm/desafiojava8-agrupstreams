package br.com.softplan.desafiojava8.agrupstreams;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import br.com.softplan.desafiojava8.agrupstreams.auxiliar.Seriado;
import br.com.softplan.desafiojava8.agrupstreams.auxiliar.Temporadas;
import br.com.softplan.desafiojava8.agrupstreams.auxiliar.Tupla;

public class AppSeriado {

    public static void main(String[] args) {

        // com base nos dados das temporadas da serie 'Kamen Rider',
        // calcule as estatisticas abaixo
        List<Seriado> temporadas = Temporadas.getKamemRider();

        //1. O total de episódios exibidos no Brasil, de todas as séries
        int totalEpisodios = temporadas.stream()
                .filter(s -> s.getExibidoNoBrasil())
                .map(s -> s.getNumeroEpisodios())
                .reduce(0, (a, b) -> a + b);
        System.out.println(totalEpisodios);

        //2. A média de episódios de cada década, em ordem decrescente
        temporadas.stream()
            .collect(Collectors.groupingBy(s -> (s.getAno() / 10) * 10))
            .entrySet()
            .stream()
            .map(e -> {
                Double media = e.getValue()
                        .stream()
                        .mapToDouble(s -> s.getNumeroEpisodios())
                        .average()
                        .orElse(0.0);

                return new Tupla<Integer, Double>(e.getKey(), media);
            })
            .sorted((a, b) -> b.getB().compareTo(a.getB()))
            .forEach(t -> System.out.println(t));

        // 3. Compare a media de episodios das series exibidas no Brasil em relação às que não foram
        temporadas.stream()
            .collect(Collectors.partitioningBy(s -> s.getExibidoNoBrasil(), Collectors.averagingDouble(s -> s.getNumeroEpisodios())))
            .entrySet()
            .stream()
            .forEach(e -> System.out.println((e.getKey() ? "No Brasil: " : "No Exterior: ") + e.getValue()));



    }

}
