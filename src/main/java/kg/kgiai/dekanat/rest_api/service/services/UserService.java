package kg.kgiai.dekanat.rest_api.service.services;

import kg.kgiai.dekanat.rest_api.model.ApplicationUser;
import kg.kgiai.dekanat.rest_api.service.Service;

import javax.transaction.NotSupportedException;

public interface UserService extends Service<ApplicationUser, Long> {

    @Override
    ApplicationUser getByName(String name);
}
