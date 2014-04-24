package com.example.eyal.badber.sidemenu;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {

	//������ ������ ���
	// Within which the entire activity is enclosed
		private DrawerLayout mDrawerLayout;

		// ListView represents Navigation Drawer
		private ListView mDrawerList;

		// ActionBarDrawerToggle indicates the presence of Navigation Drawer in the action bar
		private ActionBarDrawerToggle mDrawerToggle;

		// Title of the action bar
		private String mTitle = "";

  @SuppressLint("NewApi")
  @Override
  protected void onCreate(Bundle savedInstanceState) {

			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main);
            
			/**���� ������ ���� �� ������ ������ */
			mTitle = "eyal i close";
			getActionBar().setTitle(mTitle);

			// Getting reference to the DrawerLayout
			mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

			mDrawerList = (ListView) findViewById(R.id.drawer_list);

			// Getting reference to the ActionBarDrawerToggle
			mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
					R.drawable.ic_drawer, R.string.drawer_open,
					R.string.drawer_close) {

/** ���� ������ ��� ������  */
				
  public void onDrawerClosed(View view) {
					
     getActionBar().setTitle(mTitle);
     invalidateOptionsMenu();

				}

/** ���� ������ ���� �� ������ */
  public void onDrawerOpened(View drawerView) {
	getActionBar().setTitle("eyal i open");
	invalidateOptionsMenu();
   }

};

			// Setting DrawerToggle on DrawerLayout
			mDrawerLayout.setDrawerListener(mDrawerToggle);

			// Creating an ArrayAdapter to add items to the listview mDrawerList
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(), 
					R.layout.drawer_list_item, getResources().getStringArray(R.array.menus));

			// Setting the adapter on mDrawerList
			mDrawerList.setAdapter(adapter);

			// Enabling Home button
			getActionBar().setHomeButtonEnabled(true);

			// Enabling Up navigation
			getActionBar().setDisplayHomeAsUpEnabled(true);

			// Setting item click listener for the listview mDrawerList
			mDrawerList.setOnItemClickListener(new OnItemClickListener() {
    
				
	@Override//����� ������ ���
	public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {

				// ���� ���� �� ������� ������ ������
				String[] menuItems = getResources().getStringArray(R.array.menus);

				// Currently selected river
				mTitle = menuItems[position];

		         //����� �������� ����� ������ ���� �� ����� ������
				 menuSelection(position);
					
				
				// Getting reference to the FragmentManager
				FragmentManager fragmentManager = getFragmentManager();

				// Creating a fragment transaction
				FragmentTransaction ft = fragmentManager.beginTransaction();

				

					// Committing the transaction
					ft.commit();

					// Closing the drawer
					mDrawerLayout.closeDrawer(mDrawerList);

				}
			});
		}
       
/** ��� ���� ��� */

/** �������� ������ ���*/
/** ������� ����� ������ �� ����� */
  protected void menuSelection(int position) {
	//������� ����� ������ ����� �� ����� �� ����� ��� �����
			
	switch (position) {
			case 0:
				Toast.makeText(MainActivity.this,position+" eyal" , Toast.LENGTH_SHORT).show();
				break;
			case 1:
				Toast.makeText(MainActivity.this,position+" eyal" , Toast.LENGTH_SHORT).show();
				break;
			case 2:
				Toast.makeText(MainActivity.this,position+" eyal" , Toast.LENGTH_SHORT).show();
				break;
			case 3:
				Toast.makeText(MainActivity.this,position+" eyal" , Toast.LENGTH_SHORT).show();
				break;
			case 4:
				Toast.makeText(MainActivity.this,position+" eyal" , Toast.LENGTH_SHORT).show();
				break;
			case 5:
				Toast.makeText(MainActivity.this,position+" eyal" , Toast.LENGTH_SHORT).show();
				break;
			case 6:
				Toast.makeText(MainActivity.this,position+" eyal" , Toast.LENGTH_SHORT).show();
				break;
			default:
				break;
			}
		}
	 
@Override
  protected void onPostCreate(Bundle savedInstanceState) {
	//���� ���� onResume
	//����� �����  
	//������ ������ ������ ����� ��� ������� �� ���� ��� �� ���� ��. �� �� ��, ���� ������
	//FragmentActivity
	super.onPostCreate(savedInstanceState);
			mDrawerToggle.syncState();
		}

@Override
  public boolean onOptionsItemSelected(MenuItem item) {
	//���� ��� ��� ����� ������ ��������� ��� ����	
	   if (mDrawerToggle.onOptionsItemSelected(item)) {
				return true;
			}
			return super.onOptionsItemSelected(item);
		}

/** ���� ��� ��� ���� ������  ������ ���  */
		@Override
 public boolean onPrepareOptionsMenu(Menu menu) {
			// �� ������ �����, ������ ����� ����� ���� ������ �����
			//�� ������ ���� �� ������ �� ������ ����� �����
			boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
            //������� ���� ����
			menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
			return super.onPrepareOptionsMenu(menu);
		}

 @Override//
 public boolean onCreateOptionsMenu(Menu menu) {
			getMenuInflater().inflate(R.menu.main, menu);
			return true;
		}
	}
