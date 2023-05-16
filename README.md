# GitHubUsers
Application created according to clean architecture, so here we got 3 main layers - domain, data and app (di + app class + presentation inside).
Let's talk about domain first - here we have 2 data classes (entities), 3 usecases and repository interface, of course domain is completely
independent from libraries or other layers. Data - repository implementation, entities as a data-model (because I need to add annotations from
Room and Retrofit, but I can't do it right in domain) and mapper (i need to use domain model in presentation layer, so I map DbModel to domain).
Also there are Database (using Room) where I store loaded users and Retrofit for loading that data. For dependency injection I used Koin, 
because it's very small and comfortable library. In presentation layer I decided to try single activity pattern, so there is only one 
activity and 2 fragments, first (with recyclerView) is a basic one, second (with detailed info) changes the first one when user clicks on 
recyclerView item. Also there is UsersViewModel, where i work with usecases and setting liveDatas.  
So list of used technologies/decisions: clean architecture, single activity, MVVM, coroutines, Retrofit (GSON as a converter factory), 
Room, Koin, Glide, fragments.
