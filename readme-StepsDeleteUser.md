# Steps to implement the delete user functionality

s1) add column on interface (e.g create.xhtml)
			<p:column headerText="Operations">
				<h:outputText value="abc" />

				
			</p:column>
			
s2) add delete button 
			<p:column headerText="Operations">
				<h:outputText value="abc" />

				<p:commandButton id="userDeleteButton" value="Delete" 
					actionListener="#{createController.deleteUser(user)}" 
					update=":frmContent:userslist">
				</p:commandButton>
				
			</p:column>

s3) add delete-method into controller - CreateController
	public String deleteUser (User u) {
		userDao.deleteUserByID (u);
		return "pretty:createView";
	}

s4) add delete method into DAO service (interface + implementation)
a) interface
		void deleteUserByID(User u);
b) implementation
	@Override
	public void deleteUserByID(User u) {
		try {
			Query query = entityManager.createQuery("delete from User u where u.id = :uid");
			query.setParameter("uid", u.getId());
			query.executeUpdate();
			entityManager.flush();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
	}
