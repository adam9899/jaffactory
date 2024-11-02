package app.tombplays.jaffactory.worldgen.feature.tree;

import app.tombplays.jaffactory.worldgen.feature.configurations.JaffaTreeConfiguration;
import com.mojang.serialization.Codec;

public class JaffaTreeFeature extends JAFTreeFeature<JaffaTreeConfiguration>{
    protected JaffaTreeFeature(Codec<JaffaTreeConfiguration> codec) {
        super(codec);
    }
}
