package camping.user.CampingUser.core.utulites.mappers;


import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

@Service

public class ModelMapperManager implements ModelMaperService {

    private final ModelMapper modelMapper;

    public ModelMapperManager(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ModelMapper forResponse() {
        this.modelMapper.getConfiguration() .setAmbiguityIgnored(true)
                .setMatchingStrategy (MatchingStrategies.LOOSE);
        return this.modelMapper;
    }


    //request olduğunu hepsini maple
    @Override
    public ModelMapper forRequest() {
        this.modelMapper.getConfiguration() .setAmbiguityIgnored(true)
                .setMatchingStrategy (MatchingStrategies.STANDARD);
        return this.modelMapper;
    }
}
