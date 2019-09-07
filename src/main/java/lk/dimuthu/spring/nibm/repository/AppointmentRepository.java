package lk.dimuthu.spring.nibm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lk.dimuthu.spring.nibm.domain.Appointment;

/**
 * <p>AppointmentRepository interface.</p>
 *
 * @author Toan Quach
 * @version $Id: $Id
 */

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {

}
