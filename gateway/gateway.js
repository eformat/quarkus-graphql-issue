const { ApolloServer } = require('@apollo/server');
const { ApolloGateway, IntrospectAndCompose } = require('@apollo/gateway');
const { startStandaloneServer } = require('@apollo/server/standalone');

const gateway = new ApolloGateway({
 supergraphSdl: new IntrospectAndCompose({
   subgraphs: [
       { name: 'Product', url: 'http://127.0.0.1:8081/graphql' },
       { name: 'Review', url: 'http://127.0.0.1:8082/graphql' },
       // ...additional subgraphs...
   ],
   // Experimental: Enabling this enables the query plan view in Playground.
   __exposeQueryPlanExperimental: true,
 }),
});

(async () => {
  const server = new ApolloServer({
    gateway,

    // Apollo Graph Manager (previously known as Apollo Engine)
    // When enabled and an `ENGINE_API_KEY` is set in the environment,
    // provides metrics, schema management and trace reporting.
    engine: false,

    // Subscriptions are unsupported but planned for a future Gateway version.
    subscriptions: false,
  });

  const { url } = await startStandaloneServer(server, {
    listen: { port: 4000 },
  });

  console.log(`🚀  Server ready at: ${url}`);

})();
