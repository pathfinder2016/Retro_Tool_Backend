package com.retro.core.retro.service;

import com.retro.core.retro.model.Action;
import com.retro.core.retro.repository.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActionServiceImpl implements ActionService {
    @Autowired
    ActionRepository actionRepository;
    @Override
    public Action create(Action action) {
        return actionRepository.save(action);
    }

    @Override
    public Action getActionByRetroKey(String retroKey) {
        return actionRepository.findByRetroKey(retroKey);
    }
}
