package mockarooAPI;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Player {

	@JsonProperty("birthdate")
	private String birthdate;

	@JsonProperty("home_country")
	private String homeCountry;

	@JsonProperty("last_name")
	private String lastName;

	@JsonProperty("id")
	private int id;

	@JsonProperty("jersey_number")
	private int jerseyNumber;

	@JsonProperty("position")
	private String position;

	@JsonProperty("team_id")
	private String teamId;

	@JsonProperty("first_name")
	private String firstName;

	public String getBirthdate(){
		return birthdate;
	}

	public String getHomeCountry(){
		return homeCountry;
	}

	public String getLastName(){
		return lastName;
	}

	public int getId(){
		return id;
	}

	public int getJerseyNumber(){
		return jerseyNumber;
	}

	public String getPosition(){
		return position;
	}

	public String getTeamId(){
		return teamId;
	}

	public String getFirstName(){
		return firstName;
	}

	@Override
 	public String toString(){
		return 
			"Player{" +
			"birthdate = '" + birthdate + '\'' + 
			",home_country = '" + homeCountry + '\'' + 
			",last_name = '" + lastName + '\'' + 
			",id = '" + id + '\'' + 
			",jersey_number = '" + jerseyNumber + '\'' + 
			",position = '" + position + '\'' + 
			",team_id = '" + teamId + '\'' + 
			",first_name = '" + firstName + '\'' + 
			"}";
		}
}