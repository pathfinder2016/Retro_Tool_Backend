package com.retro.core.retro.service;

import com.retro.core.retro.model.Action;

public interface ActionService {
    Action create(Action action);

    Action getActionByRetroKey(String retroKey);
}
