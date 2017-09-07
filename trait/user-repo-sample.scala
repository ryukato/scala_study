class User
class EntityManager {
  def createQuery(query: String, claz: Class): EntityManager = this
  def getResultList = List()
}

trait UserRepositoryComponent {
  def userLocator: UserLocator
  def userUpdater: UserUpdater

  trait UserLocator {
    def findAll: java.util.List[User]
  }
  trait UserUpdater {
    def save(user: User)
  }
}

trait UserRepositoryJPAComponent extends UserRepositoryComponent {
  val em: EntityManager
  def userLocator = new UserLocatorJPA(em)
  def userUpdater = new UserUpdaterJPA(em)

  class UserLocatorJPA(val em: EntityManager) extends UserLocator {
    def findAll = em.createQuery("from User", classOf[User]).getResultList
  }

  // def classOf
}
