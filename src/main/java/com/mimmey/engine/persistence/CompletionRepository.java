package com.mimmey.engine.persistence;

import com.mimmey.engine.business.entities.Completion;
import com.mimmey.engine.business.entities.User;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompletionRepository extends PagingAndSortingRepository<Completion, Integer> {
    Completion save(Completion completion);

    @Query(value = "SELECT c FROM Completion c WHERE c.user = ?1")
    Page<Completion> getCompletions(User user, Pageable pageable);
}
