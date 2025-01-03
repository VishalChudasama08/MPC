package in.v8.main.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import in.v8.main.HibernateConfig;
import in.v8.main.entities.Notes;

@Service
public class NotesServiceImpl implements NotesService {

	@Override
	public int addNote(Notes note) {
		Transaction transaction = null;
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
	public Notes getThisNote(Long id) {
		try(Session session = HibernateConfig.getSessionFactory().openSession()){
			return session.get(Notes.class, id);
		}
	}
	
	@Override
	public int updateNote(Notes editedNote, Long id) {
		Transaction transaction = null;
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
		    Notes oldNote = session.get(Notes.class, id); // Fetch the existing note
		    if (oldNote != null) { // here note exist it means that id note exist and id present in that object (means oldNote.id is not null)
		        // Set the existing id and userId to the editedNote
		        editedNote.setId(oldNote.getId());
		        editedNote.setUserId(oldNote.getUserId());
		        editedNote.setCreated_date(oldNote.getCreated_date()); // Preserve created_date, not do this than update time create date value null insert in database
		        editedNote.setBg_color(oldNote.getBg_color());
		        editedNote.setPinned(oldNote.isPinned());
		        
		        // Update the note
	            session.merge(editedNote); // Merge updates an entity if it exists
	            transaction.commit();
		        return 1;
		    } else {
		        return 0;
		    }
		} catch (Exception e) {
	        if (transaction != null) transaction.rollback();
	        e.printStackTrace();
	        return 0; // Indicate an error
	    }
	}

	@Override
	public String deleteNote(Long id) {
		Transaction transaction = null;
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {
		    transaction = session.beginTransaction();
		    Notes note = session.get(Notes.class, id); // get this note by id
		    if (note != null) { // note have ? than delete
		        session.delete(note);
		        transaction.commit();
		        return "Note deleted successfully";
		    }
		} catch (Exception e) {
		    if (transaction != null) transaction.rollback();
		    e.getMessage();
		}
		return "Note not deleted or note not Found.";
	}

	@Override
	public int updateBGColor(Long id, String color) {
		Transaction transaction = null;
	    int rowsAffected = 0;
	    try (Session session = HibernateConfig.getSessionFactory().openSession()) {
	        transaction = session.beginTransaction();
	        
	        String hql = "UPDATE Notes SET bgColor = :color WHERE id = :id";
	        rowsAffected = session.createQuery(hql)
	                              .setParameter("color", color)
	                              .setParameter("id", id)
	                              .executeUpdate();
	        
	        transaction.commit();
	    } catch (Exception e) {
	        if (transaction != null) transaction.rollback();
	        e.printStackTrace();
	    }
	    return rowsAffected;
	}

	@Override
	public int updatePinStatus(Long id, Boolean pinned) {
		Transaction transaction = null;
	    int rowsAffected = 0;
	    try (Session session = HibernateConfig.getSessionFactory().openSession()) {
	        transaction = session.beginTransaction();
	        
	        String hql = "UPDATE Notes SET pinned = :pinned WHERE id = :id";
	        rowsAffected = session.createQuery(hql)
	                              .setParameter("pinned", pinned)
	                              .setParameter("id", id)
	                              .executeUpdate();
	        
	        transaction.commit();
	    } catch (Exception e) {
	        if (transaction != null) transaction.rollback();
	        e.printStackTrace();
	    }
	    return rowsAffected;
	}
}
