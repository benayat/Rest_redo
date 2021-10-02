
<h1>rest service with elasticsearch:</h1>

<p>a spring boot simple rest microservice, connected to an elasticsearch instance in a container.</p>

run:
docker-compose -f ./docker-compose.yml up -d

challenges: 
it's worth mentioning the challenge in connecting both containers, or specifically - 
connecting a spring boot app container to an elastic container. 
some things to note:
<ul>
<li>the host name inside a docker-network is the container name.</li>
<li>the spring boot app must wait for the DB to start. I found two ways to manage that:
<ol>
<li>either use the <a href="https://github.com/vishnubob/wait-for-it">wait for it</a> repo</li>
<li>or use healthcheck as a condition for "depends on" elasticsearch, in the spring-boot service</li>
</ol>
I chose the second approach, which is cleaner.
</li>
</ul>
that's it! 
if there is a problem/question, open an issue in this repo.
