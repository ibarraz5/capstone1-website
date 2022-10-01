import { useState } from "react";

const GroupedTeamMembers = ({ employees, selectedTeam, setTeam }) => {
  const [groupedEmployees, setGroupedData] = useState(groupTeamMembers());

  function groupTeamMembers() {
    let teams = [];

    let teamAMembers = filterTeamMembers("TeamA");
    let teamA = createTeamItem("TeamA", teamAMembers);
    teams.push(teamA);

    let teamBMembers = filterTeamMembers("TeamB");
    let teamB = createTeamItem("TeamB", teamBMembers);
    teams.push(teamB);

    let teamCMembers = filterTeamMembers("TeamC");
    let teamC = createTeamItem("TeamC", teamCMembers);
    teams.push(teamC);

    let teamDMembers = filterTeamMembers("TeamD");
    let teamD = createTeamItem("TeamD", teamDMembers);
    teams.push(teamD);

    return teams;
  }

  function filterTeamMembers(members) {
    return employees.filter((employee) => employee.teamName === members);
  }

  function createTeamItem(team, members) {
    let newTeam = {
      team: team,
      members: members,
      collapsed: selectedTeam === team ? false : true,
    };
    return newTeam;
  }

  function handleTeamClick(event) {
    let transformedGroupData = groupedEmployees.map((groupedData) =>
      groupedData.team === event.currentTarget.id
        ? { ...groupedData, collapsed: !groupedData.collapsed }
        : groupedData
    );
    setGroupedData(transformedGroupData);
    setTeam(event.currentTarget.id);
  }

  return (
    <main className="container">
      {groupedEmployees.map((item) => {
        return (
          <div
            key={item.team}
            className="card mt-2"
            style={{ cursor: "pointer" }}
          >
            <h4
              id={item.team}
              className="card-header text-secondary bg-white"
              onClick={handleTeamClick}
            >
              Team Name: {item.team}
            </h4>
            <div
              id={"collapse_" + item.team}
              className={item.collapsed === true ? "collapse" : ""}
            >
              <hr />
              {item.members.map((member) => {
                return (
                  <div className="mt-2">
                    <h5 className="card-title mt-2">
                      <span className="text-dark">
                        Full Name: {member.fullName}
                      </span>
                    </h5>
                    <p>Designation: {member.designation}</p>
                  </div>
                );
              })}
            </div>
          </div>
        );
      })}
    </main>
  );
};

export default GroupedTeamMembers;
