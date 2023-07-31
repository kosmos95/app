package flutter.app.repository;

import flutter.app.model.Target;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TargetRepository extends JpaRepository<Target, Long>, TargetRepositoryCustom {


}
