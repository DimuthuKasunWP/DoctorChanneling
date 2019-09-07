package lk.dimuthu.spring.nibm.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import lk.dimuthu.spring.nibm.domain.Appointment;
import lk.dimuthu.spring.nibm.domain.Doctor;
import lk.dimuthu.spring.nibm.domain.Specialization;

/**
 * <p>DoctorService interface.</p>
 *
 * @author kamanashisroy
 * @version $Id: $Id
 */
public interface DoctorService {

	/**
	 * <p>saveDoctor.</p>
	 *
	 * @param doctor a {@link Doctor} object.
	 */
	public void saveDoctor(Doctor doctor);

	/**
	 * <p>updateDoctor.</p>
	 *
	 * @param doctor a {@link Doctor} object.
	 */
	public void updateDoctor(Doctor doctor);

	/**
	 * <p>getAll.</p>
	 *
	 * @return a list of doctors
	 */
	List<Doctor> getAll();

	/**
	 * <p>findDoctorById.</p>
	 *
	 * @param id a int.
	 * @return Doctor
	 */
	Doctor findDoctorById(int id);

	/**
	 * <p>findDoctorBySpecialization.</p>
	 *
	 * @param specialization a {@link Specialization} object.
	 * @return a {@link java.util.Map} object.
	 */
	Map<Integer, String> findDoctorBySpecialization(Specialization specialization);

	/**
	 * <p>findDoctorByEmail.</p>
	 *
	 * @param name a {@link java.lang.String} object.
	 * @return a {@link Doctor} object.
	 */
	Doctor findDoctorByEmail(String name);

	/**
	 * <p>getUpcomingAppointment.</p>
	 *
	 * @param appointmentList a {@link java.util.List} object.
	 * @return a {@link java.util.Map} object.
	 */
	Map<Date, List<Appointment>> getUpcomingAppointment(List<Appointment> appointmentList);

	/**
	 * <p>getOverdueAppointment.</p>
	 *
	 * @param appointmentList a {@link java.util.List} object.
	 * @return a {@link java.util.Map} object.
	 */
	Map<Date, List<Appointment>> getOverdueAppointment(List<Appointment> appointmentList);
}
