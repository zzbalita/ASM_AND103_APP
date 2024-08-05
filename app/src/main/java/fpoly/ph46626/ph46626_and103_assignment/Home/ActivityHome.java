package fpoly.ph46626.ph46626_and103_assignment.Home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import fpoly.ph45160.ph45160_and103_assignment.R;
import fpoly.ph45160.ph45160_and103_assignment.databinding.ActivityHomeBinding;
import fpoly.ph46626.ph46626_and103_assignment.Cart.FragmentCart;
import fpoly.ph46626.ph46626_and103_assignment.Favorite.FragmentFavorite;
import fpoly.ph46626.ph46626_and103_assignment.Home.Fragment.FragmentProduct;
import fpoly.ph46626.ph46626_and103_assignment.Notification.FragmentNotification;


public class ActivityHome extends AppCompatActivity {

    ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fr_container, new FragmentProduct())
                .commit();

        binding.bottomNavigation.setOnItemSelectedListener( item -> {
            Fragment selectedFragment =  null;
            if (item.getItemId() == R.id.navHome) {
                selectedFragment = new FragmentProduct();
            } else if (item.getItemId() == R.id.navCart) {
                selectedFragment = new FragmentCart();
            } else if (item.getItemId() == R.id.navFavorite) {
                selectedFragment = new FragmentFavorite();
            } else {
                selectedFragment = new FragmentNotification();
            }
            return loadFragment(selectedFragment);
        });

    }
    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fr_container, fragment);
            transaction.commit();
            return true;
        }
        return false;
    }
}