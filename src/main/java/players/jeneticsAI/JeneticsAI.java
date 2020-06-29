package players.jeneticsAI;

import io.jenetics.*;
import io.jenetics.engine.*;
import io.jenetics.util.IntRange;

public class JeneticsAI {
    public static void main(String[] args) {

        final Engine<IntegerGene,Integer> engine = Engine
                .builder(Fitness::numberOfBetsUntilQuit,
                        Codecs.ofScalar(IntRange.of(0,1000)))
                .populationSize(100)
                .optimize(Optimize.MAXIMUM)
                .selector(new TournamentSelector<>())
                .alterers(new Mutator<>(0.55)
                        ,   new SinglePointCrossover<>(0.1))
                .build();

        final EvolutionStatistics<Integer,?> statistics = EvolutionStatistics.ofNumber();

        final Phenotype<IntegerGene, Integer> best =
                engine.stream()
                        .limit(Limits.bySteadyFitness(8))
                        .limit(100)
                        .peek(statistics)
                        .collect(EvolutionResult.toBestPhenotype());

        System.out.println(statistics);
        System.out.println(best);
        System.out.println("Optimal number of rounds to play: " + best.genotype().gene().allele()
                + "  Fitness: " + best.fitness());
    }
}
