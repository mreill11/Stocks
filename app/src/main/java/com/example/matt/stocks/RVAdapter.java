package com.example.matt.stocks;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.matt.stocks.Model.Company;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.CompanyViewHolder> {

    public static class CompanyViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView sid;
        TextView companyName;
        TextView currentValue;
        TextView percentChange;
        ImageView changeIndicator;

        CompanyViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.card_view);
            sid = (TextView) itemView.findViewById(R.id.sid_textview);
            companyName = (TextView) itemView.findViewById(R.id.company_name_textview);
            currentValue = (TextView) itemView.findViewById(R.id.quote_textview);
            percentChange = (TextView) itemView.findViewById(R.id.change_textview);
            changeIndicator = (ImageView) itemView.findViewById(R.id.arrow_imageview);
        }
    }

    List<Company> companies;

    RVAdapter(List<Company> companies) {
        this.companies = companies;
    }

    @Override
    public int getItemCount() {
        return companies.size();
    }

    @Override
    public CompanyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        CompanyViewHolder cvh = new CompanyViewHolder(v);
        return cvh;
    }

    @Override
    public void onBindViewHolder(CompanyViewHolder companyViewHolder, int i) {
        //companyViewHolder.sid.setText(companies.get(i).getSymbol());
        //companyViewHolder.companyName.setText(companies.get(i).getName());
        //companyViewHolder.currentValue.setText(companies.get(i).getExchange());
    }
}