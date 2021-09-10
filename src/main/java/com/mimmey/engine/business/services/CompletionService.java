package com.mimmey.engine.business.services;

import com.mimmey.engine.business.entities.Completion;
import com.mimmey.engine.business.entities.User;
import com.mimmey.engine.persistence.CompletionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class CompletionService {

    @Autowired
    private CompletionRepository completionRepository;

    public Page<Completion> getCompletions(User user, Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by("completedAt").descending());
        return completionRepository.getCompletions(user, paging);
    }

    public Completion save(Completion completion) {
        return this.completionRepository.save(completion);
    }
}
