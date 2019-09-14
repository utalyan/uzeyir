package todo;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import todo.model.Todo;
import todo.model.User;
import todo.service.TodoService;
import todo.service.UserService;


public class ScreenHelper {
	
	private boolean isClose = false;
	private boolean isLogin = false;
	private boolean isFind = false;
	private boolean isInList = true;

	private String inputValue;
	private String inputUserName;
	
	private int findIndex = 0;

	private User loginUser = null;
	private Todo selectedTodo = null;

	private  UserService userSvc = null ;
	private  TodoService todoSvc = null ;
	
	public ScreenHelper()
	{
		userSvc = new UserService();
		todoSvc = new TodoService();
	}

	public void mainScreen()
	{

		this.clearScreen();

		while (!isClose) {

			while (!isLogin) {
				this.loginProcess();
			}

			while (isLogin && !isClose) {
				this.mainProcess();
			}

		}

	   } 
	
	private  void loginProcess()
	{
		
		this.clearScreen();

		this.loginMenuDraw();

		this.fillBlankRow(3);

		inputValue = System.console().readLine("Se�im Yap�n�z >_");

		switch (inputValue) {
		case "1":
			this.clearScreen();
			inputUserName = System.console().readLine("Kullan�c� Ad�n�z� Giriniz >_");

			if (userSvc.existsByName(inputUserName)) {
				loginUser = userSvc.findByName(inputUserName).get(0);
			}

			if (loginUser == null) {
				isLogin = false;
				
				System.out.println("Kullan�c� Ad� Bulunamad�. " + inputUserName);
				this.fillBlankRow(3);
				System.console().readLine("Devam ��in Enter >_");

			} else {
				isLogin = true;
			}

			break;
		case "2":

			this.clearScreen();

			inputUserName = System.console().readLine("Yeni Kullan�c� Ad�n�z� Giriniz >_");

			if (inputUserName == null || inputUserName.trim().isEmpty()) {
				System.out.println("Uygun �sim Giriniz. ");

				this.fillBlankRow(3);
				System.console().readLine("Devam ��in Enter >_");

				isFind=true;
				
			}
			if (userSvc.existsByName(inputUserName) && !isFind) {
				System.out.println("Kullan�c� Ad� Daha �nce Girilmi�. " + inputUserName);

				this.fillBlankRow(3);
				System.console().readLine("Devam ��in Enter >_");

				isFind=true;

			}

			if (!isFind) {
				User u = new User();

				u.setName(inputUserName);

				userSvc.create(u);

				System.out.println("Kullan�c� Tan�m� Ba�ar�l�. " + inputUserName);

				this.fillBlankRow(3);
				System.console().readLine("Devam ��in Enter >_");
				
			}
			isFind=false;


			break;
		case "3":
			
			this.clearScreen();
			
			List<User> userList = userSvc.getAllList();
			
			System.out.println("Kullanici Listesi");
			this.fillStarOnLine(13);

			for (User u : userList) {
				System.out.println(u.getId() + " " + u.getName());
			}
			
			this.fillStarOnLine(13);;
			this.fillBlankRow(3);

			inputValue = System.console().readLine("Devam ��in Enter >_");

			break;
		case "4":

			isClose = true;
			isLogin = true;

			break;

		default:
			break;
		}

	}
	
	private void mainProcess()
	{
		this.clearScreen();

		this.mainMenuDraw(loginUser.getName());

		this.fillBlankRow(3);

		inputValue = System.console().readLine("Se�im Yap�n�z >_");

		switch (inputValue) {
		case "1":

			this.clearScreen();

			isFind=false;
			inputValue = System.console().readLine("A��klama Giriniz > ");

			if (inputValue == null || inputValue.trim().isEmpty()) {
				System.out.println("A��klama Giriniz. ");

				this.fillBlankRow(3);
				System.console().readLine("Devam ��in Enter >_");

				isFind=true;
				
			}
			
			if (!isFind) {
				Todo t = new Todo();

				t.setDescription(inputValue);
				t.setStatus(true);
				t.setUserId(loginUser.getId());

				todoSvc.create(t);				
			}

			break;
		case "2":

			while (isInList) {
				
				this.clearScreen();
	
				System.out.println("ToDo Listesi");
				this.fillStarOnLine(13);
	
				// todoSvc.todoGetList().stream().filter(td->td.getTodoUserId().equals(loginUser.getUserId()));
	
				System.out.println(this.fixedLengthString("ID", 20) + this.fixedLengthString("Aciklama", 30) + this.fixedLengthString("Durum", 7));
				this.fillStarOnLine(75);
				for (Todo td : todoSvc.todoList(loginUser.getId())) {
					System.out.println(this.fixedLengthString(td.getId().toString(),20) + " " + this.fixedLengthString(td.getDescription(),30) + " " + this.fixedLengthString(td.isStatus()==true?"aktif":"pasif",7) );
				}
	
				this.fillStarOnLine(75);
				this.fillBlankRow(3);
	
				this.todoActionMenuDraw();
	
				inputValue = System.console().readLine("Se�im Yap�n�z >_");
	
				switch (inputValue) {
				case "1":
					inputValue = System.console().readLine("Durumunu De�i�tirmek ��in Kay�d�n ID Bilgisini Giriniz >_");
					
					if (inputValue.matches("[0-9]")) {
						Todo t = todoSvc.findById(Long.parseLong(inputValue));
						if (t != null)
						{
							t.setStatus(false);
							
							todoSvc.update(t);
							
						}
					}
					
					break;
				case "2":
					inputValue = System.console().readLine("Silmek �ste�iniz Kay�d�n ID Bilgisini Giriniz >_");
	
					if (inputValue.matches("[0-9]")) {
						if (todoSvc.findById(Long.parseLong(inputValue)) != null)
						{
							todoSvc.delete(Long.parseLong(inputValue));

						}
					}
					
					break;
				case "3":
					isInList = false;
					break;
	
				default:
					break;
				}
			}

			break;
		case "3":
			isLogin = false;

			break;

		case "4":

			isClose = true;
			isLogin = true;

			break;

		default:
			break;
		}


	}
	
	private void fillBlankRow(int rowCount) {
		
		for (int i = 0; i < rowCount; i++) {
			System.out.println();
		}
		
	}
	
	private void fillStarOnLine(int starCount) {
		
		char[] array = new char[starCount];
		
		Arrays.fill(array, '*');
		System.out.println(new String(array));
	}
	
	
	private void loginMenuDraw() {
		System.out.println("******************************");
		System.out.println("1. Kullan�c� Giri�i");
		System.out.println("2. Yeni Kullan�c� Tan�mlama");
		System.out.println("3. Listele");
		System.out.println("4. Programdan ��k");
		System.out.println("******************************");
	}

	private void mainMenuDraw(String loginUser) {
		System.out.println("Merhaba " + loginUser);
		System.out.println("******************************");
		System.out.println("1. Todo Olu�tur");
		System.out.println("2. Todo Listele");
		System.out.println("3. Farkl� Kullan�c� �le Ba�lan");
		System.out.println("4. Programdan ��k");
		System.out.println("******************************");

	}

	private void todoActionMenuDraw() {
		System.out.println("******************************");
		System.out.println("1. Todo Durum De�i�tir");
		System.out.println("2. Todo Sil");
		System.out.println("3. Ana Menuye Don");
		System.out.println("******************************");

	}

	private void clearScreen() {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String fixedLengthString(String string, int length) {
	    return String.format("%1$"+length+ "s", string);
	}


}
