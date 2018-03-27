import requests
from operator import itemgetter
import pprint

pp = pprint.PrettyPrinter(indent=1)
def get_teams(event):
    r = requests.get("http://www.thebluealliance.com/api/v3/event/" + event + "/teams/simple", headers={"X-TBA-Auth-Key":"v62ZvFvAkyWVH1qwd1m8Kyyhll0VEvyxUGo7pqpM1re827yjVZlgtjdpBEQJNcn2"}).json()
    list_of_teams = []
    for team in r:
        list_of_teams.append(team.get('team_number'))
    list_of_teams.sort()
    
    f = open(event + "-teams.txt", "a")
    for team in list_of_teams:
        f.write(str (team))
        f.write("\n")
    f.close()

def get_matches(event):
    r = requests.get("http://www.thebluealliance.com/api/v3/event/" + event + "/matches/simple", headers={"X-TBA-Auth-Key":"v62ZvFvAkyWVH1qwd1m8Kyyhll0VEvyxUGo7pqpM1re827yjVZlgtjdpBEQJNcn2"}).json()
    r = [x for x in sorted(r, key=itemgetter('match_number')) if x["comp_level"] == "qm"]
    
    f = open(event + "-matches.txt", "a")
    for match in r:
        blue_teams = [team.strip('frc') for team in match.get("alliances").get("blue").get("team_keys")]
        red_teams = [team.strip('frc') for team in match.get("alliances").get("red").get("team_keys")]
        f.write(str (match.get("match_number")) + ",")
        for i in range(0, len(blue_teams)):
            f.write(blue_teams[i])
            if i == 2:
                continue
            else:
                f.write(" ")
        f.write(",")
        for i in range(0, len(red_teams)):
            f.write(red_teams[i])
            if i == 2:
                continue
            else:
                f.write(" ")
        f.write("," + str (match.get("alliances").get("blue").get("score")))
        f.write("," + str (match.get("alliances").get("red").get("score")))
        f.write("\n")
    f.close()
get_teams("2018azfl")
get_matches("2018azfl")