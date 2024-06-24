package total.people.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import total.people.entity.People;

public interface peopleRepository extends JpaRepository<People, String>, JpaSpecificationExecutor<People> {
    Page<People> findAll(Specification<People> specification, Pageable pageable);
}
