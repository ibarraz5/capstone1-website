var baseUrl = "http://localhost:8080/wea/"

async function getMessageList(ao) {
    const result = await fetch(`${baseUrl}getMessageList?sender=${ao}`)
    const data = await result.json();

    console.log(data);
}

module.exports = "Database";