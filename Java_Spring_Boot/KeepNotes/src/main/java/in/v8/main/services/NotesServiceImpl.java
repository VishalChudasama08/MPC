package in.v8.main.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import in.v8.main.HibernateConfig;
import in.v8.main.entities.Notes;

@Service
public class NotesServiceImpl implements NotesService {
	
	Transaction transaction = null;

	@Override
	public int addNote(Notes note) {
		try(Session session = HibernateConfig.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			session.save(note);
			transaction.commit();			
			return 1;
		} catch (Exception e) {
		    if (transaction != null) transaction.rollback();
		    e.printStackTrace();
		    return 0;
		}
	}

	@Override
	public List<Notes> getAllNotesByUserId(Long userId) {
		try(Session session = HibernateConfig.getSessionFactory().openSession()){			
			String hql = "FROM Notes WHERE userId = :userId";
	        return session.createQuery(hql, Notes.class)
	                      .setParameter("userId", userId)
	                      .getResultList();
		}
	}

	@Override
	public Optional<Notes> getThisNote(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public int updateNote(Notes editedNote, Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String deleteNote(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateBGColor(Long id, String color) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatePinStatus(Long id, Boolean pinned) {
		// TODO Auto-generated method stub
		return 0;
	}

//	@Override
//	public Optional<Notes> getThisNote(Long id) {
//		return notesRepository.findById(id);
//	}
//	
//	@Override
//	public int updateNote(Notes editedNote, Long id) {
//	    Notes oldNote = notesRepository.findById(id).orElse(null);
//	    if (oldNote != null) { // here note exist it means that id note exist and id present in that object (means oldNote.id is not null)
//	        // Set the existing id and userId to the editedNote
//	        editedNote.setId(oldNote.getId());
//	        editedNote.setUserId(oldNote.getUserId());
//	        editedNote.setCreated_date(oldNote.getCreated_date()); // Preserve created_date, not do this than update time create date value null insert in database
//	        editedNote.setBg_color(oldNote.getBg_color());
//	        editedNote.setPinned(oldNote.isPinned());
//
//	        // Save the updated note
//	        notesRepository.save(editedNote); // if in provided entity object id is exist than JPA do update else JPA perform a new save
//	        return 1;
//	    } else {
//	        return 0;
//	    }
//	}
//
//	@Override
//	public String deleteNote(Long id) {
//		if (notesRepository.existsById(id)) {
//			notesRepository.deleteById(id);
//			return "Note deleted successfully";
//		} else {			
//			return "Note not deleted or note not Found.";
//		}
//	}
//
//	@Override
//	public int updateBGColor(Long id, String color) {
//		return notesRepository.updateNoteBgColor(id, color);
//	}
//
//	@Override
//	public int updatePinStatus(Long id, Boolean pinned) {
//		return notesRepository.updatePinnedStatus(id, pinned);
//	}
}
