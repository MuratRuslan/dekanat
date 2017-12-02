package kg.kgiai.dekanat.rest_api.service.services.impl;

import kg.kgiai.dekanat.rest_api.model.ApplicationUser;
import kg.kgiai.dekanat.rest_api.repository.ApplicationUserRepository;
import kg.kgiai.dekanat.rest_api.service.services.AbstractService;
import kg.kgiai.dekanat.rest_api.service.services.UserService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.NotSupportedException;

@Service
public class UserServiceImpl extends AbstractService<ApplicationUser, Long> implements UserService {
    public UserServiceImpl(JpaRepository<ApplicationUser, Long> repository) {
        super(repository);
    }

    @Override
    public ApplicationUser getByName(String name) {
        return ((ApplicationUserRepository)repository).findByUsername(name);
    }
}
