package de.blox.graphview.sample.Algorithms;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import de.blox.graphview.Graph;
import de.blox.graphview.GraphAdapter;
import de.blox.graphview.Node;
import de.blox.graphview.sample.GraphActivity;
import de.blox.graphview.sample.R;
import de.blox.graphview.tree.BuchheimWalkerAlgorithm;
import de.blox.graphview.tree.BuchheimWalkerConfiguration;

import static de.blox.graphview.tree.BuchheimWalkerConfiguration.ORIENTATION_LEFT_RIGHT;

public class BuchheimWalkerActivity extends GraphActivity {

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.menu_buchheim_walker_orientations, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    final BuchheimWalkerConfiguration.Builder builder = new BuchheimWalkerConfiguration.Builder()
        .setSiblingSeparation(100)
        .setLevelSeparation(300)
        .setOrientation(ORIENTATION_LEFT_RIGHT)
        .setSubtreeSeparation(300);

    switch (item.getItemId()) {
      case R.id.topToBottom:
        builder.setOrientation(BuchheimWalkerConfiguration.ORIENTATION_TOP_BOTTOM);
        break;
      case R.id.bottomToTop:
        builder.setOrientation(BuchheimWalkerConfiguration.ORIENTATION_BOTTOM_TOP);
        break;
      case R.id.leftToRight:
        builder.setOrientation(BuchheimWalkerConfiguration.ORIENTATION_LEFT_RIGHT);
        break;
      case R.id.rightToLeft:
        builder.setOrientation(BuchheimWalkerConfiguration.ORIENTATION_RIGHT_LEFT);
        break;
      default:
        return super.onOptionsItemSelected(item);
    }
    adapter.setAlgorithm(new BuchheimWalkerAlgorithm(builder.build()));
    adapter.notifyInvalidated();
    return true;
  }

  @Override
  public Graph createGraph() {
    final Graph graph = new Graph();
    final Node node1 = new Node(getNodeText());
    final Node node2 = new Node(getNodeText());
    final Node node3 = new Node(getNodeText());
    final Node node4 = new Node(getNodeText());
    final Node node5 = new Node(getNodeText());
    final Node node6 = new Node(getNodeText());
    final Node node8 = new Node(getNodeText());
    final Node node7 = new Node(getNodeText());
    final Node node9 = new Node(getNodeText());
    final Node node10 = new Node(getNodeText());
    final Node node11 = new Node(getNodeText());
    final Node node12 = new Node(getNodeText());

    graph.addEdge(node1, node2);
    graph.addEdge(node1, node3);
    graph.addEdge(node1, node4);
    //graph.addEdge(node2, node5);
    //graph.addEdge(node2, node6);
    //graph.addEdge(node6, node7);
    //graph.addEdge(node6, node8);
    //graph.addEdge(node4, node9);
    //graph.addEdge(node4, node10);
    //graph.addEdge(node4, node11);
    //graph.addEdge(node11, node12);

    return graph;
  }

  @Override
  public void setAlgorithm(GraphAdapter adapter) {
    final BuchheimWalkerConfiguration configuration = new BuchheimWalkerConfiguration.Builder()
        .setSiblingSeparation(100)
        .setLevelSeparation(300)
        .setSubtreeSeparation(300)
        .setOrientation(BuchheimWalkerConfiguration.ORIENTATION_TOP_BOTTOM)
        .build();
    adapter.setAlgorithm(new BuchheimWalkerAlgorithm(configuration));
  }
}
