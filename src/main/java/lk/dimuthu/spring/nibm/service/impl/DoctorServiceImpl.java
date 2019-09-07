package lk.dimuthu.spring.nibm.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lk.dimuthu.spring.nibm.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lk.dimuthu.spring.nibm.domain.Appointment;
import lk.dimuthu.spring.nibm.domain.Authority;
import lk.dimuthu.spring.nibm.domain.AuthorityRole;
import lk.dimuthu.spring.nibm.domain.Doctor;
import lk.dimuthu.spring.nibm.domain.Specialization;
import lk.dimuthu.spring.nibm.service.DoctorService;
import lk.dimuthu.spring.nibm.util.FamilyDoctorUtil;

@Service
/**
 * <p>DoctorServiceImpl class.</p>
 *
 * @author kamanashisroy
 * @version $Id: $Id
 */
@Transactional
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;

	/** {@inheritDoc} */
	@Override
	public void saveDoctor(Doctor doctor) {
		Authority authority = new Authority();
		authority.setAuthorityRole(AuthorityRole.ROLE_DOCTOR);
		doctor.getUser().getAuthorities().add(authority);

		String encodedPassword = FamilyDoctorUtil.hashPassword(doctor.getUser().getPassword());
		doctor.getUser().setPassword(encodedPassword);

		doctorRepository.save(doctor);
	}

	/** {@inheritDoc} */
	@Override
	public void updateDoctor(Doctor doctor) {
		Doctor doctorUpdate = doctorRepository.findDoctorById(doctor.getDoctorId());

		doctorUpdate.setFirstName(doctor.getFirstName());
		doctorUpdate.setLastName(doctor.getLastName());
		doctorUpdate.setDateOfBirth(doctor.getDateOfBirth());
		doctorUpdate.setGender(doctor.getGender());
		doctorUpdate.setLicenseNumber(doctor.getLicenseNumber());
		doctorUpdate.setSpecialization(doctor.getSpecialization());

		doctorUpdate.getAddress().setCity(doctor.getAddress().getCity());
		doctorUpdate.getAddress().setState(doctor.getAddress().getState());
		doctorUpdate.getAddress().setStreet(doctor.getAddress().getStreet());
		doctorUpdate.getAddress().setZipcode(doctor.getAddress().getZipcode());

		doctorUpdate.getUser().setEmail(doctor.getUser().getEmail());

		if (!doctor.getUser().getPassword().isEmpty()) {
			String encodedPassword = FamilyDoctorUtil.hashPassword(doctor.getUser().getPassword());
			doctorUpdate.getUser().setPassword(encodedPassword);
		}

		doctorRepository.save(doctorUpdate);
	}

	/** {@inheritDoc} */
	@Override
	public List<Doctor> getAll() {
		List<Doctor> doctors = new ArrayList<Doctor>();

		for (Doctor d : doctorRepository.findAll()) {
			doctors.add(d);
		}

		return doctors;
	}

	/** {@inheritDoc} */
	public Doctor findDoctorById(int id) {
		Doctor doctor = doctorRepository.findDoctorById(id);
		return doctor;
	}

	/** {@inheritDoc} */
	@Override
	public Map<Integer, String> findDoctorBySpecialization(Specialization spec) {
		List<Doctor> doctors = doctorRepository.findDoctorBySpecialization(spec);

		if (doctors.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Integer, String> doctorMap = new HashMap<>();
		for (Doctor doctor : doctors) {
			doctorMap.put(doctor.getDoctorId(), doctor.getFullName());
		}

		return doctorMap;
	}

	/** {@inheritDoc} */
	@Override
	public Doctor findDoctorByEmail(String email) {
		return doctorRepository.findDoctorByEmail(email);
	}

	/** {@inheritDoc} */
	@Override
	public Map<Date, List<Appointment>> getUpcomingAppointment(List<Appointment> appointmentList) {
		return FamilyDoctorUtil.mapAppointmentFromList(appointmentList, false);
	}

	/** {@inheritDoc} */
	@Override
	public Map<Date, List<Appointment>> getOverdueAppointment(List<Appointment> appointmentList) {
		return FamilyDoctorUtil.mapAppointmentFromList(appointmentList, true);
	}
}
