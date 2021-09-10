package com.mimmey.engine.presentation;

import com.mimmey.engine.business.entities.Completion;
import com.mimmey.engine.business.services.CompletionService;
import com.mimmey.engine.business.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompletionController {

    @Autowired
    private CompletionService completionService;

    @GetMapping("api/quizzes/completed")
    public Page<Completion> getCompletions(@AuthenticationPrincipal User user,
                                           @RequestParam(defaultValue = "0") Integer page,
                                           @RequestParam(defaultValue = "10") Integer pageSize) {
        return completionService.getCompletions(user, page, pageSize);
    }
}
