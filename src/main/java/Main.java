import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    private static SessionFactory sessionFactory;
    public static void main(String[] args) {

        try {
            setUp();
            guardar("Paca la Piraña", "1");
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    private static void guardar(String nombre, String numAciertos){
        PersonasEntity persona = new PersonasEntity(nombre, numAciertos);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        int id = (int) session.save(persona);

        try {
            transaction.commit();
        } catch (Exception e) {
           transaction.rollback();
        }

        System.out.println(id);
        sessionFactory.close();
    }

    protected static void setUp() throws Exception {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // por defecto: hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            StandardServiceRegistryBuilder.destroy( registry );
        }
    }
}
