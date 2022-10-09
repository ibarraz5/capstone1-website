import { useGlobalContext } from "../context";

const Tables = () => {
  const { sampleData } = useGlobalContext();

  return (
    <section>
      {sampleData.map((person) => {
        const { fullname, location, occupation } = person;

        return (
          <div
            style={{
              display: "flex",
              gap: ".5rem",
              alignItems: "center",
              justifyContent: "left",
              paddingLeft: "3.5rem",
              paddingBottom: "2rem",
            }}
          >
            <p>
              <strong>{fullname}:</strong>{" "}
            </p>
            <p>Location: {location} |</p>
            <p> Occupation: {occupation}</p>
          </div>
        );
      })}
    </section>
  );
};

export default Tables;
