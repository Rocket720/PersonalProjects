TEAMS = 7
MATCHES_PER_TEAM = 4


def choose(allies=[[0] * TEAMS] * TEAMS, opponents=[[0] * TEAMS] * TEAMS):
    for match in find_matches(allies, opponents):
        new_allies = [list(team) for team in allies]
        new_opponents = [list(team) for team in opponents]
        for side in [0, 1]:
            match_allies = match[side]
            match_opponents = match[1 - side]
            for team in [0, 1]:
                team_num = match_allies[team];
                new_allies[team_num][match_allies[1 - team]] += 1
                new_opponents[team_num][match_opponents[0]] += 1
                new_opponents[team_num][match_opponents[1]] += 1


def find_matches(allies, opponents):
    remaining = [allies.index(team) for team in allies if sum()]


choose(7, 4)
