package com.rdlts.arcus.identity.user.applicationservice.command;

import com.rdlts.arcus.ddd.core.domain.cqrs.Command;

public interface CreateArcusUserCommand extends Command {

    String username();

    String password();

    String email();
}
