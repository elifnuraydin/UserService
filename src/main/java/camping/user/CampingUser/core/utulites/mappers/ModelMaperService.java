package camping.user.CampingUser.core.utulites.mappers;

import jakarta.persistence.Id;
import org.modelmapper.ModelMapper;

public interface ModelMaperService {
    ModelMapper forResponse();

    ModelMapper forRequest();
}
