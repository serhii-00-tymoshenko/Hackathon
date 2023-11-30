package com.mintokoneko.hackathon.ui.employees

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.mintokoneko.hackathon.databinding.FragmentEmployeesBinding
import com.mintokoneko.hackathon.entities.Employee
import com.mintokoneko.hackathon.ui.employees.adapters.EmployeeAdapter

class EmployeesFragment : Fragment(), EmployeesContractor.View {
    private var _binding: FragmentEmployeesBinding? = null
    private val binding get() = _binding!!
    private lateinit var presenter: EmployeesPresenter
    private lateinit var model: EmployeesModel
    private lateinit var employeeAdapter: EmployeeAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEmployeesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        model = EmployeesModel()
        presenter = EmployeesPresenter(this, model)

        employeeAdapter = EmployeeAdapter() { employee ->
            presenter.onItemClick(employee)
        }

        binding.employees.apply {
            adapter = employeeAdapter
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
        }

        employeeAdapter.submitList(model.getEmployees())
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun navigateToDetails(employee: Employee) {
        Toast.makeText(requireContext(), employee.name, Toast.LENGTH_SHORT).show()
    }
}