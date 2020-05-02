package mensajeJPA.dao;

import java.util.List;

import javax.persistence.EntityManager;

import mensajeJPA.entities.Usuario;
import mensajeJPA.util.Conexion;


public class UsuarioDAO {
EntityManager em=null;
	
	public UsuarioDAO() {
		em = Conexion.getEm();
		
		
	}
	
	public List<Usuario> listar(){
		return (List<Usuario>) em.createQuery("select x from Usuario x").getResultList();	
		
	}
	
	
	 public void registrar (Usuario usuario) {
		 try {
			 em.getTransaction().begin();
			 em.persist(usuario);
			 em.getTransaction().commit();
			 } catch (Exception e) {
			 e.printStackTrace();
			 }finally {
			 em.close();
			 }
		
		 
		 
	 }
	 
	 public void actualizar (Usuario usuario) {
		 try {
			 em.getTransaction().begin();
			 em.merge(usuario);
			 em.getTransaction().commit();
			 } catch (Exception e) {
			 e.printStackTrace();
			 }finally {
			 em.close();
			 }
		
		 
		 
	 }
	 
	 public void eliminar (int id){
		 try {

             Usuario u = em.find(Usuario.class, id);
			 em.getTransaction().begin();
			 em.remove(u);
			 em.getTransaction().commit();
			 } catch (Exception e) {
			 e.printStackTrace();
			 }finally {
			 em.close();
			 }
		
		 
		 
	 }
	 
	 public void buscar (Integer m) {
		 try {
			 em.getTransaction().begin();
			 Usuario u = em.find(Usuario.class, m);
			 em.getTransaction().commit();
			 System.out.println(u.getUser());	
			  
			 } catch (Exception e) {
			 e.printStackTrace();
			 }finally {
			 em.close();
			 }
		
		 
		 
	 }
}
