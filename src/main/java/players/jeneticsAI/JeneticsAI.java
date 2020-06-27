package players.jeneticsAI;

import Actions.PlayerAction;
import io.jenetics.*;
import io.jenetics.engine.*;
import io.jenetics.util.IntRange;
import players.scoreexclusionAI.ScoreExclusionAI;

public class JeneticsAI {
    public static void main(String[] args) {

        final Engine<IntegerGene,Integer> engine=Engine
                .builder(Fitness::fitness,
                        Codecs.ofScalar(IntRange.of(0,1)))
                .populationSize(1_000)
                .optimize(Optimize.MAXIMUM)
                .selector(new RouletteWheelSelector<>())
                .build();

        final EvolutionStatistics<Integer,?> statistics = EvolutionStatistics.ofNumber();

        final Phenotype<IntegerGene, Integer> best =
                engine.stream()
                        .limit(Limits.bySteadyFitness(7))
                        .limit(100)
                        .peek(statistics)
                        .collect(EvolutionResult.toBestPhenotype());

        System.out.println(statistics);
        System.out.println(best);

    }
}
